package com.muratkistan.product_service.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
