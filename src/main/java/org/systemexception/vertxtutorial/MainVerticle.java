package org.systemexception.vertxtutorial;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author leo
 * @date 5/11/15 15:58
 */
public class MainVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> future) {
		vertx.createHttpServer().requestHandler(r -> {
			r.response().setChunked(true);
			r.response().write("<h1>Hello from my first Vert.x 3 application</h1>");
			r.response().write("<hr>");
			r.response().write(getDate());
			r.response().end();
		}).listen(8080, result -> {
			if (result.succeeded()) {
				future.complete();
			} else {
				future.fail(result.cause());
			}
		});
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Shut down...");
	}

	private String getDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
		return localDateTime.format(dateTimeFormatter);
	}
}
