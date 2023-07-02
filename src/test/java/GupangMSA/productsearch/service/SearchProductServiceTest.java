package GupangMSA.productsearch.service;

import GupangMSA.productsearch.domain.SearchProduct;
import GupangMSA.productsearch.domain.SearchProductRequest;
import GupangMSA.productsearch.mock.FakeSearchProductRepository;
import GupangMSA.productsearch.service.port.SearchProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchProductServiceTest {

    private SearchProductService searchProductService;

    @BeforeEach
    void init() {
        SearchProduct searchProduct1 = SearchProduct.builder()
                .productId(1L)
                .name("apple")
                .price(1000)
                .category("fruit")
                .build();
        SearchProduct searchProduct2 = SearchProduct.builder()
                .productId(2L)
                .name("apple")
                .price(1200)
                .category("fruit")
                .build();
        SearchProduct searchProduct3 = SearchProduct.builder()
                .productId(3L)
                .name("apple")
                .price(1300)
                .category("fruit")
                .build();

        SearchProductRepository searchProductRepository = new FakeSearchProductRepository();
        searchProductRepository.save(searchProduct1);
        searchProductRepository.save(searchProduct2);
        searchProductRepository.save(searchProduct3);
        this.searchProductService = new SearchProductService(searchProductRepository);
    }

    @Test
    void create메서드로_새로운_SearchProduct_도메인을_만들수_있다() {
        // given
        SearchProductRequest request = SearchProductRequest.builder()
                .productId(1L)
                .name("apple")
                .price(1000)
                .category("fruit")
                .build();

        // when
        SearchProduct searchProduct = this.searchProductService.create(request);

        // then
        assertThat(searchProduct.getId()).isNotNull();
        assertThat(searchProduct.getCategory()).isEqualTo("fruit");
    }

    @Test
    void search_함수를_이용해_검색어로_SearchProduct들을_가져온다() {
        // given
        String searchWord = "apple";

        // when
        List<SearchProduct> searchProducts = this.searchProductService.search(searchWord);

        // then
        assertThat(searchProducts.get(0).getPrice()).isEqualTo(1000);
        assertThat(searchProducts.get(1).getPrice()).isEqualTo(1200);
        assertThat(searchProducts.get(2).getPrice()).isEqualTo(1300);
    }



}
