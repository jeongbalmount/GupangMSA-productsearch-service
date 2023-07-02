package GupangMSA.productsearch.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchProduct {

    private final String id;
    private final Long productId;
    private final String name;
    private final int price;
    private final String category;

    @Builder
    public SearchProduct(String id, Long productId, String name, int price, String category) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static SearchProduct from(SearchProductRequest request) {
        return SearchProduct.builder()
                .productId(request.getProductId())
                .name(request.getName())
                .price(request.getPrice())
                .category(request.getCategory())
                .build();
    }
}
