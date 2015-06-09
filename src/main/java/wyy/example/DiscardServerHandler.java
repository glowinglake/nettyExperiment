package wyy.example;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter { // (1)

    //    @Override
    /*
    @Override
	public void messageReceived(ChannelHandlerContext ctx, Object msg) {
	// discard
    }
    */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
	ByteBuf in = (ByteBuf) msg;
		ctx.write(msg); // (1)
		ctx.flush(); // (2)

    }
    @Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}