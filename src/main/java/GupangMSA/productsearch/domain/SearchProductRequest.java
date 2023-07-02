package GupangMSA.productsearch.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchProductRequest {

    private final Long productId;
    private final String name;
    private final int price;
    private final String category;

    @Builder
    public SearchProductRequest(Long productId, String name, int price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
