package com.muratkistan.product_service.schedule;

import com.muratkistan.product_service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSchedule {

    private final ProductService productService;

    @Scheduled(fixedRate = 3600000)
    public void productListRefresh(){
        productService.getProductListCacheUpdate();
    }
}
