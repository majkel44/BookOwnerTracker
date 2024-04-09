package Lab5.Gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${book.url}") String bookUrl,
			@Value("${owner.url}") String ownerUrl,
			@Value("${gateway.host}") String host
	) {
		return builder
				.routes()
				.route("owners", route -> route
						.host(host)
						.and()
						.path(
								"/api/owners/{ownerID}",
								"/api/owners"
						)
						.uri(ownerUrl)
				)
				.route("characters", route -> route
						.host(host)
						.and()
						.path(
								"/api/books",
								"/api/books/{bookID}",
								"/api/owners/{ownerID}/books"
						)
						.uri(bookUrl)
				)
				.build();
	}

}
