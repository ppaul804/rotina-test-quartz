package br.com.ppaul804.rotinatestquartz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private UUID id;
    private String name;
    private String description;
    private String authorName;
    private BigDecimal cost;
}
