package GupangMSA.productsearch.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchProductTest {

    @Test
    void create_함수로_새로운_productSearch_도메인을_만들_수_있다() {
        // given
        SearchProductRequest request = SearchProductRequest.builder()
                .productId(1L)
                .name("apple")
                .price(1000)
                .category("fruit")
                .build();

        // when
        SearchProduct searchProduct = SearchProduct.from(request);


        // then
        assertThat(searchProduct.getName()).isEqualTo("apple");
    }

}
