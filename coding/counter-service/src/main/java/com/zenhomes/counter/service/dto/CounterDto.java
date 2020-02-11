package com.zenhomes.counter.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author LoganPhan
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CounterDto implements Serializable { 

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private BigDecimal amount;

    private Long counterId;
    
    public void setAmount(BigDecimal amount) {
    	this.amount = amount.setScale(3, RoundingMode.FLOOR);
    }
}
