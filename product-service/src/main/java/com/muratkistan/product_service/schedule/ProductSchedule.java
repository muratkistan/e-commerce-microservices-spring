package com.muratkistan.product_service.schedule;

import com.muratkistan.product_service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductSchedule {

    private final ProductService productService;

    @Scheduled(fixedRate = 10000)
    public void productListRefresh(){
        log.info("Product List Cache Refreshed");
        productService.getProductListCacheUpdate();
    }
}
