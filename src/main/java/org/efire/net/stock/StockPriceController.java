package org.efire.net.stock;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class StockPriceController {

    @GetMapping(value = "/stocks/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StockPrice> price(@PathVariable("symbol") String symbol) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(r -> new StockPrice(symbol, randomStockPrice(), LocalDateTime.now()));
    }

    private Double randomStockPrice() {
        return ThreadLocalRandom.current().nextDouble(100.0);
    }
}
