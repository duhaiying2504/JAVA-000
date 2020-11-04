package dhy.xly.nio.gateway.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dhy.xly.nio.gateway.filter.HttpRequestFilter;
import dhy.xly.nio.gateway.outbound.httpclient5.HttpHeaderFilter;
import dhy.xly.nio.gateway.outbound.httpclient5.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
	private final String proxyServer;
	private HttpOutboundHandler handler;
	private HttpRequestFilter filter;

	public HttpInboundHandler(String proxyServer) {
		this.proxyServer = proxyServer;
		handler = new HttpOutboundHandler(this.proxyServer);
		this.filter = new HttpHeaderFilter();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		try {
			// logger.info("channelRead流量接口请求开始，时间为{}", startTime);
			FullHttpRequest fullRequest = (FullHttpRequest) msg;
			// 路由 TODO
			filter.filter(fullRequest, ctx);
			handler.handle(fullRequest, ctx);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

}
