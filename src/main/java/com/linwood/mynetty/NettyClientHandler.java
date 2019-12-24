package com.linwood.mynetty;

import java.security.PublicKey;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
	//连接服务器完成时触发
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		
	}
	
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
		
	
	}
	//有读取事件时触发
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(msg.trim());
		
	}

}
