package com.learning.microservices.userservice.resource;

import com.learning.microservices.userservice.entity.ApplicationLocale;
import com.learning.microservices.userservice.mapper.ApplicationLocaleMapper;
import com.learning.microservices.userservice.model.ApplicationLocaleDto;
import com.learning.microservices.userservice.repository.ApplicationLocaleRepository;
import com.learning.microservices.userservice.repository.CountryMasterRepository;
import com.learning.microservices.userservice.repository.LanguageMasterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class ApplicationLocaleResourceTest {

    private MockMvc mockMvc;

    private Long id;

    @Autowired
    private ApplicationLocaleResource applicationLocaleResource;

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Autowired
    private LanguageMasterRepository languageMasterRepository;

    @Autowired
    private ApplicationLocaleRepository applicationLocaleRepository;

    @Autowired
    private ApplicationLocaleMapper applicationLocaleMapper;

    @BeforeEach
    public void setup() {
        this.mockMvc = standaloneSetup(this.applicationLocaleResource).build();

        Random random = new Random();
        id = random.nextLong() & Long.MAX_VALUE;
    }

    @Test
    @DirtiesContext
    public void getAllApplicationLocalesTest() throws Exception {
        String uri = "/app-locales";
        String countryISO = "US";
        String languageCode = "en";

        ApplicationLocale applicationLocale = new ApplicationLocale();
        applicationLocale.setCountryISO(countryISO);
        applicationLocale.setLanguageCode(languageCode);
        applicationLocaleRepository.save(applicationLocale);

        ApplicationLocaleDto applicationLocaleDto = applicationLocaleMapper.toDto(applicationLocale);

        this.mockMvc.perform(get(uri))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].locale", is(applicationLocaleDto.getLocale())))
                    .andReturn();
    }


}
