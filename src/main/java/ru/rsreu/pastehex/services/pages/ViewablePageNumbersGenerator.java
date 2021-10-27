package ru.rsreu.pastehex.services.pages;

import java.util.ArrayList;
import java.util.List;

public class ViewablePageNumbersGenerator {
    private final ElementsPagesDisplayConfiguration elementsPagesDisplayConfiguration;

    public ViewablePageNumbersGenerator(ElementsPagesDisplayConfiguration elementsPagesDisplayConfiguration) {
        this.elementsPagesDisplayConfiguration = elementsPagesDisplayConfiguration;
    }

    public List<Integer> getViewablePagesNumbers(int currentPageNumber) {
        int realPagesQuantity = calculateRealElementsPagesQuantity(
                elementsPagesDisplayConfiguration.getElementsQuantity(),
                elementsPagesDisplayConfiguration.getPageSize());
        if (realPagesQuantity <= elementsPagesDisplayConfiguration.getViewablePagesQuantity()) {
            return generatePagesNumbers(1, realPagesQuantity);
        }
        int maxGeneratedPageNumber = calculateMaxGeneratedPageNumber(
                realPagesQuantity,
                elementsPagesDisplayConfiguration.getViewablePagesQuantity(),
                currentPageNumber
        );
        return generatePagesNumbers(
                maxGeneratedPageNumber - elementsPagesDisplayConfiguration.getViewablePagesQuantity() + 1,
                maxGeneratedPageNumber
        );
    }

    private int calculateMaxGeneratedPageNumber(int realPagesQuantity,
                                                int viewablePagesQuantity,
                                                int currentPageNumber) {
        return Math.min(realPagesQuantity, Math.max(viewablePagesQuantity, currentPageNumber + 1));
    }

    private int calculateRealElementsPagesQuantity(int elementsQuantity, int pageSize) {
        return (int) Math.ceil((double) elementsQuantity / pageSize);
    }

    private List<Integer> generatePagesNumbers(int first, int lastInclusive) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = first; i <= lastInclusive; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
