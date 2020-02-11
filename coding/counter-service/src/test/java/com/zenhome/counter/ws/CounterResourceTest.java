package com.zenhome.counter.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.zenhomes.counter.CounterApplication;
import com.zenhomes.counter.domain.Counter;
import com.zenhomes.counter.service.CounterService;
import com.zenhomes.counter.service.dto.CounterDto;
import com.zenhomes.counter.service.mapper.CounterMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CounterApplication.class)
@AutoConfigureMockMvc
public class CounterResourceTest {
	
	 private static final BigDecimal DEFAULT_AMOUNT_1 = new BigDecimal(1000.123).setScale(3, RoundingMode.FLOOR);
	 private static final Long DEFAULT_COUNTER_ID_1 = 1001L;
	 
	@Autowired
	private MockMvc restCounterMockMvc;

	@Autowired
	private CounterService counterService;
	
	@Autowired
	private EntityManager em;
	
    @Autowired
    private CounterMapper counterMapper;
    
	private Counter counterInit;
	
    
    public static Counter createEntity(EntityManager em) {
    	return Counter.builder()
    			.counterId(DEFAULT_COUNTER_ID_1)
				.amount(DEFAULT_AMOUNT_1)
				.build();
	}
    
	@Before
	public void initTest() {
		counterInit = createEntity(em);
	}

	@Test
	public void createCounter() throws Exception {
		int databaseSizeBeforeCreate = counterService.getCounters().size();
		counterInit.setId(null);
		CounterDto dto = counterMapper.toDto(counterInit);
		restCounterMockMvc.perform(post("/counter_callback").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(dto)))
				.andExpect(status().isCreated());

		List<CounterDto> counters = counterService.getCounters().stream().collect(Collectors.toList());
		assertThat(counters).hasSize(databaseSizeBeforeCreate + 1);

		CounterDto testCounter = counters.get(counters.size() - 1);
		assertThat(testCounter.getAmount()).isEqualTo(DEFAULT_AMOUNT_1);
		assertThat(testCounter.getCounterId()).isEqualTo(DEFAULT_COUNTER_ID_1);

	}


	@After
	public void remove() {
		counterInit = null;
	}
}
