package com.muratkistan.product_service.product;

import java.util.List;

public interface ProductService {

    Integer createProduct(ProductRequest request);
    ProductResponse findById(Integer id);
    List<ProductResponse> findAll();
    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
}
