package com.linwood.mynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MessageServer {
	public static void main(String[] args) {
		EventLoopGroup boss = new NioEventLoopGroup(1);
		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception{
					ch.pipeline().addLast(new NettyServerHandler());
				}
			});
			System.out.println("Netty Server Start");
			ChannelFuture cf = bootstrap.bind(9000).sync();
			cf.addListener(new ChannelFutureListener() {
				
				 public void operationComplete(ChannelFuture future) throws Exception{
					if(future.isSuccess()) {
						System.out.println("Listener port succed");
					}else {
						System.out.println("Listener port fail");
					}
			}
			});
			cf.channel().closeFuture().sync();
		}catch(Exception e) {
			System.out.println("Start server error");
		}
		finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

}
