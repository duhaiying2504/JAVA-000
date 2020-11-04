/**
 * 
 */
package dhy.xly.nio.gateway.outbound.httpclient5;

import dhy.xly.nio.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * <p>
 * 	请求头filter
 * </p>
 *
 * @author duhaiying
 */
public class HttpHeaderFilter implements HttpRequestFilter {

	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		
		fullRequest.headers().add("nio", "duhaiying");
	}

}
