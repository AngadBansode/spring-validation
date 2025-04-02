package com.validation.webflux;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class ReactiveTest {

    @Test
    public void monoTest(){
        Mono<String> stringMono = Mono.just("Dwija").log();
//         stringMono.subscribe(System.out::println);

       // Mono on Exception
        Mono<?> stringMono1 = Mono.just("Dwija")
                .then(Mono.error(new RuntimeException("Mono Exception")))
                .log();
        stringMono1.subscribe(System.out::println,throwable -> System.out.println(throwable));
    }

    @Test
    public void fluxTest(){
       Flux<String> stringFlux = Flux.just("abc","def","xyz")
               .concatWithValues("AWS","Cloud")
               .doOnError(Throwable::printStackTrace)// if any error
               .concatWith(Flux.error(new RuntimeException("Exception custom")))
               .concatWithValues("After-Error")
               .log();
       stringFlux.subscribe(System.out::println);
    }

    @Test
    public void fluxDelayTest(){
      Flux<String> integerFlux =  Flux.just("a","b","c","d")
//                .delayElements(Duration.ofSeconds(4))
                .concatWithValues("e")
                .doOnNext(ele -> System.out.println("Values: " + ele))
                .log();

      integerFlux.subscribe((vals) -> System.out.println("sub: " + vals));

    }

    // int val
    @Test
    public void fluxDelayIntTest(){
        Flux<Integer> integerFlux =  Flux.just(1,2,4,5)
//                .delayElements(Duration.ofSeconds(4))
                .concatWithValues(3)
                .doOnNext(ele -> System.out.println("Values: " + ele))
                .log();

        integerFlux.subscribe((vals) -> System.out.println("sub: " + vals));

    }

    @Test
    public void fluxTestSomeRequest(){

        Flux<String> stringFlux = Flux.just("a", "b", "c", "d", "e", "f")
                .log()
                .limitRequest(2);
        stringFlux.subscribe(System.out::print);

    }
    @Test
    public void fluxList(){
        var integerFlux = Flux.fromIterable(List.of(1, 2, 3, 4, 5));
        integerFlux.delayElements(Duration.ofSeconds(10))
                .doOnNext(element -> System.out.println("element: " + element) )
                .concatWithValues(6,7,8)
                        .log();


        integerFlux.subscribe(System.out::println);

    }
    // MOno
    @Test
    public void monoTestList(){
//        Mono.
    }

    // flatMap - Flux<String>

    public void flatMapFluxTest(){

         Flux.just("R","A","V","I")
                 .map(ele -> ele.concat(ele))
                 .log();
    }

    // concatMap()

}
