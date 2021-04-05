package com.zenhomes.counter.ws.vm;

import java.math.BigDecimal;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

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

	public static String returnCode(String code){
		return code;
	}
}
