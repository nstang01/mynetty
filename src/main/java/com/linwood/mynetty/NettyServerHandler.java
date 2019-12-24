package com.linwood.mynetty;

import java.security.PublicKey;
import java.text.SimpleDateFormat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyServerHandler extends SimpleChannelInboundHandler<String>{
	private static ChannelGroup channelgroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
