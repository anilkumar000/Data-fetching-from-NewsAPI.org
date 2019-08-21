package com.ruchik.streamsDemo.ApiCalls;

import org.graalvm.compiler.nodes.calc.ObjectEqualsNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MakeCalls {
    // /statuses/home_timeline.json
    WebClient client = WebClient.builder()
            .baseUrl("https://api.twitter.com/1.1")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .defaultHeaders(HttpHeaders.AUTHORIZATION, OAuth)
            .build();

    @GetMapping("/tweets")
    public Flux<?> getTweets() {
        List<Object> myArray = new ArrayList<>();
        Flux<?> response = Flux.fromIterable(myArray);

          return client.get()
                .uri("/statuses/home_timeline.json")
                .header("Authorization", "OAuth oauth_consumer_key=\"SOnXMD3VSmGD5KTkj37rSQHAE\",oauth_token=\"3158369077-1QS3eTlW0Q8LvXvlkyPOEAaQaBO6aFVaKZ0tgie\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1566283643\",oauth_nonce=\"51PROn\",oauth_version=\"1.0\",oauth_signature=\"3h%2FFicHF6yb%2BAhTsyFz6uh7tNbg%3D\"")
                    .retrieve()
                  .bodyToFlux(Object.class);
//                .exchange().filter(a -> myArray.add(a));
//                .flatMapMany(clientResponse -> myArray.add(clientResponse.bodyToMono(Object.class)));

//          return  response;
    }

}
