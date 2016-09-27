package org.systemexception.vertxtutorial.Main;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author leo
 * @date 5/11/15 15:58
 */
public class MainVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> fut) {
		vertx.createHttpServer().requestHandler(r -> {
			r.response().end("<h1>Hello from my first Vert.x 3 application</h1>");
		}).listen(8080, result -> {
			if (result.succeeded()) {
				fut.complete();
			} else {
				fut.fail(result.cause());
			}
		});
	}
}
