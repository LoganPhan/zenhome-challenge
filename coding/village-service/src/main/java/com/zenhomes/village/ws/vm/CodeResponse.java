package com.zenhomes.village.ws.vm;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author LoganPhan
 *
 */
@Data
@JacksonXmlRootElement(localName="code")
@Builder
public class CodeResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JacksonXmlText
	private String code;
}
