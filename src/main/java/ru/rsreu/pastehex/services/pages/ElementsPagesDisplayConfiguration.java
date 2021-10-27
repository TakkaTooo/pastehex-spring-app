package ru.rsreu.pastehex.services.pages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementsPagesDisplayConfiguration {
    private int pageSize;
    private int viewablePagesQuantity;
    private int elementsQuantity;
}
