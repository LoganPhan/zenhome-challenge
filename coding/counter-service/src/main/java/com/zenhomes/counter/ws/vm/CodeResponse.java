package com.zenhomes.counter.ws.vm;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author LoganPhan
 *
 */
@Data
@JacksonXmlRootElement(localName="code")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JacksonXmlText
	private String code;
}
