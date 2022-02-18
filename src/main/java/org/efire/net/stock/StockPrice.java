package org.efire.net.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StockPrice {
    private String symbol;
    private Double price;
    private LocalDateTime time;
}

