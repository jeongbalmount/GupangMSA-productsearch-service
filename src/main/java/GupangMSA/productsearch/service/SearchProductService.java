package GupangMSA.productsearch.service;

import GupangMSA.productsearch.domain.SearchProduct;
import GupangMSA.productsearch.domain.SearchProductRequest;
import GupangMSA.productsearch.service.port.SearchProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchProductService {

    private final SearchProductRepository searchProductRepository;

    SearchProduct create(SearchProductRequest request) {
        SearchProduct searchProduct = SearchProduct.from(request);
        return searchProductRepository.save(searchProduct);
    }

    List<SearchProduct> search(String searchWord) {
        return searchProductRepository.findBySearchWord(searchWord);
    }

}
