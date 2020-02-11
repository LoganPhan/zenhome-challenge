package com.zenhomes.counter.ws.vm;

import java.math.BigDecimal;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author LoganPhan
 *
 */
@Data
@Builder
public class ConsumptionReport {
	
	Collection<Village> villages;
	
	@Data
	@Builder
	@AllArgsConstructor
	public static class Village{
		private String villageName;
		private BigDecimal consumption;
	}
}
