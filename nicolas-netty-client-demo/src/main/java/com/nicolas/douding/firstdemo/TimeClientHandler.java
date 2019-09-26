package com.nicolas.douding.firstdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-09-17 17:52
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 因为 Netty 采用线程池，所以这里使用原子操作类来进行计数
     */
    private static AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 当客户端和服务端 TCP 链路建立成功之后，Netty 的 NIO 线程会调用 channelActive 方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String reqMsg = "我是客户端 " + Thread.currentThread().getName();
        byte[] reqMsgByte = reqMsg.getBytes("UTF-8");
        ByteBuf reqByteBuf = Unpooled.buffer(reqMsgByte.length);
        /**
         * writeBytes：将指定的源数组的数据传输到缓冲区
         * 调用 ChannelHandlerContext 的 writeAndFlush 方法将消息发送给服务器
         */
        reqByteBuf.writeBytes(reqMsgByte);
        ctx.writeAndFlush(reqByteBuf);
    }

    /**
     * 当服务端返回应答消息时，channelRead 方法被调用，从 Netty 的 ByteBuf 中读取并打印应答消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println((atomicInteger.addAndGet(1)) + "---" + Thread.currentThread().getName() + ",Server return Message：" + body);
        ctx.close();
    }

    /**
     * 当发生异常时，打印异常 日志，释放客户端资源
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        /**释放资源*/
        ctx.close();
    }

}
