package dhy.xly.nio.gateway.outbound.httpclient5;

import java.util.function.Function;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequests;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * httpclient5 异步、请求工具类
 * </p>
 *
 * @author duhaiying
 */
public class HttpAsynClientUtil {

	private static final Logger log = LoggerFactory.getLogger(HttpAsynClientUtil.class);

	private final static int cores = Runtime.getRuntime().availableProcessors() * 2;

	private final static IOReactorConfig ioConfig = IOReactorConfig.custom().setSoTimeout(Timeout.ofSeconds(5))
			.setIoThreadCount(cores).setRcvBufSize(32 * 1024).build();

	public static void get(final String url, Function<SimpleHttpResponse, Boolean> callback) {
		final SimpleHttpRequest httpRequest = SimpleHttpRequests.get(url);
		httpRequest.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);

		CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().setIOReactorConfig(ioConfig).build();

		httpclient.start();

		httpclient.execute(httpRequest, new FutureCallback<SimpleHttpResponse>() {

			@Override
			public void completed(final SimpleHttpResponse httpResponse) {

				callback.apply(httpResponse);

				httpclient.close(CloseMode.GRACEFUL);

				log.warn("url: {}, response body: {}", url, httpResponse.getBodyText());
			}

			@Override
			public void failed(final Exception ex) {
				log.warn("get failed, message: {}", ex.getMessage());

				httpclient.close(CloseMode.GRACEFUL);
			}

			@Override
			public void cancelled() {
				log.warn("get cancelled");
				httpclient.close(CloseMode.GRACEFUL);
			}
		});
	}

}
