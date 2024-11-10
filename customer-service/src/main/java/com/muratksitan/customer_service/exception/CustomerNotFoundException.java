package com.muratksitan.customer_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException  extends  RuntimeException{
   private final String message;


}
