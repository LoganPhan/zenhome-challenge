package com.zenhome.counter.ws;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zenhomes.counter.service.dto.CounterDto;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

import com.google.protobuf.util.*;
@RunWith(SpringRunner.class)

public class CounterResourceTest_1 {

	@Test
	public void test(){
		String[]str1 = StringUtils.split(":companyName:start_with:and::", ":");
		String[]str = "companyName:start_with:".replaceFirst("^:", "").split(":");
	}

	@Test
	public void test2(){
		CounterDto dto = new CounterDto(1L, BigDecimal.valueOf(1), null);

		Map<String, String> value = new ObjectMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL)
				.convertValue(dto, new TypeReference<Map<String, String>>() {});
		System.out.println(value);

	}

	@Test
	public void test3(){
		String regex = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
		java.util.regex.Pattern pattern = Pattern.compile(regex);
		System.out.println(pattern.matcher("As.abc@yahoo.com.uk").matches());
		System.out.println(pattern.matcher("As.abc@yahoo.com..uk").matches());
		System.out.println(pattern.matcher("-As.abc@yahoo.com.uk").matches());
		System.out.println(pattern.matcher("#As.abc@yahoo.com.uk").matches());
		System.out.println(pattern.matcher("As.abc@localhost.com").matches());
		System.out.println(pattern.matcher("As--.abc@localhost.com").matches());
		System.out.println(pattern.matcher("As-.abc@localhost.com").matches());
		System.out.println(pattern.matcher("As-..abc@localhost.com").matches());
		System.out.println(pattern.matcher("123As.abc@localhost.com").matches());
		System.out.println(pattern.matcher("123As.abc@192.168.1.1").matches());
	}

	@Test
	public void test4() throws JsonProcessingException, InvalidProtocolBufferException {
		String json = "{\n" +
				"  \"cmdId\": 1,\n" +
				"  \"version\": 2,\n" +
				"  \"getConfigurationUpdateCmdP\": {\n" +
				"      \"hash\": \"YWJjMTIzIT8kKiYoKSctPUB\",\n" +
				"      \"time\": 1608801287,\n" +
				"      \"version\": 1\n" +
				"    }\n" +
				"}";
		ObjectMapper mapper = new ObjectMapper();

		DlpMdProto.DLPProtocolMsg.Builder pro = DlpMdProto.DLPProtocolMsg.newBuilder();
		JsonFormat.parser().merge(json, pro);
		System.out.println();
	}

	@Test
	public void test5() {
//		Long da = null;
//		Date date1 = new Date(da);
//
//		Date date = new Date(1602867600000L);
//		String str1 = Instant.ofEpochMilli(1602867600000L).atZone(ZoneOffset.UTC).toLocalDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
//
//		String str = date.toString();
//		System.out.println(str);
		
//		Boolean gl = null;
//		boolean isRe = Boolean.valueOf(gl);
//		System.out.println(isRe);

		LocalDate localDate = LocalDate.parse("1614501059000", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Long s = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.printf("");
	}


}
