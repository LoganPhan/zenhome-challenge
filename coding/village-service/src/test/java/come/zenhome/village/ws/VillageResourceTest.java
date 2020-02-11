package come.zenhome.village.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zenhomes.village.VillageApplication;
import com.zenhomes.village.domain.Village;
import com.zenhomes.village.repository.VillageRepository;
import com.zenhomes.village.service.VillageService;
import com.zenhomes.village.service.dto.VillageDto;
import com.zenhomes.village.service.mapper.VillageMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VillageApplication.class)
@AutoConfigureMockMvc
public class VillageResourceTest {
	
	 private static final String DEFAULT_NAME = "AAAAAAAAAA";
	 
	@Autowired
	private MockMvc restVillageMockMvc;

	@Autowired
	private VillageService villageService;

	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private EntityManager em;
	
    @Autowired
    private VillageMapper villageMapper;
    
	private Village villageInit;

	/**
	 * Create an entity for this test.
	 *
	 * This is a static method, as tests for other entities might also need it, if
	 * they test an entity which requires the current entity.
	 */
	public static Village createEntity(EntityManager em) {
		Village village = Village.builder().name(DEFAULT_NAME).build();
		return village;
	}

	@Before
	public void initTest() {
		villageService.deleteAll();
		villageInit = createEntity(em);
	}

	@Test
	public void createVillage() throws Exception {
		int databaseSizeBeforeCreate = villageService.getVillages().size();
		villageInit.setId(null);
		// Create the Shape
		VillageDto dto = villageMapper.toDto(villageInit);
		restVillageMockMvc.perform(post("/counter").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(dto)))
				.andExpect(status()
				.isCreated());

		// Validate the Village in the VillageReposistory
		List<VillageDto> villages = villageService.getVillages().stream().collect(Collectors.toList());
		assertThat(villages).hasSize(databaseSizeBeforeCreate + 1);

		VillageDto testVillage = villages.get(villages.size() - 1);
		assertThat(testVillage.getName()).isEqualTo(DEFAULT_NAME);

	}

	@Test
	public void createVillageWithExistingId() throws Exception {
		int databaseSizeBeforeCreate = villageService.getVillages().size();

		// Create the Village with an existing ID 	
		VillageDto existingVillage = new VillageDto();
		existingVillage.setId(3L);
		// An entity with an existing ID cannot be created, so this API call must fail
		restVillageMockMvc.perform(post("/counter").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJson(existingVillage)))
				.andExpect(status()
				.isBadRequest());

		// Validate the Default Village Id in the database
		List<VillageDto> villages = villageService.getVillages();
		assertThat(villages).hasSize(databaseSizeBeforeCreate);
	}

	@Test
	public void getVillageById() throws Exception {
		Village village = villageRepository.save(villageInit);
		// Get the village by id
		restVillageMockMvc.perform(get("/counter").param("id", String.valueOf(village.getId())))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_XML))
				.andExpect(MockMvcResultMatchers.xpath("//code").exists())
				;
	}

	@After
	public void remove() {
		villageService.deleteAll();
		villageInit = null;
	}

}
