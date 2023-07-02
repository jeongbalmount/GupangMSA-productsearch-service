package GupangMSA.productsearch.service.port;

import GupangMSA.productsearch.domain.SearchProduct;

import java.util.List;

public interface SearchProductRepository {

    SearchProduct save(SearchProduct request);

    List<SearchProduct> findBySearchWord(String searchWord);

}
