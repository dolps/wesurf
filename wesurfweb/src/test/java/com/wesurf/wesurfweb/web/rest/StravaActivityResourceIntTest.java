package com.wesurf.wesurfweb.web.rest;

import com.wesurf.wesurfweb.WesurfwebApp;

import com.wesurf.wesurfweb.domain.StravaActivity;
import com.wesurf.wesurfweb.repository.StravaActivityRepository;
import com.wesurf.wesurfweb.service.StravaActivityService;
import com.wesurf.wesurfweb.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.wesurf.wesurfweb.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the StravaActivityResource REST controller.
 *
 * @see StravaActivityResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WesurfwebApp.class)
public class StravaActivityResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Float DEFAULT_DISTANCE = 1F;
    private static final Float UPDATED_DISTANCE = 2F;

    private static final String DEFAULT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_DATE = "BBBBBBBBBB";

    @Autowired
    private StravaActivityRepository stravaActivityRepository;

    @Autowired
    private StravaActivityService stravaActivityService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restStravaActivityMockMvc;

    private StravaActivity stravaActivity;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StravaActivityResource stravaActivityResource = new StravaActivityResource(stravaActivityService);
        this.restStravaActivityMockMvc = MockMvcBuilders.standaloneSetup(stravaActivityResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static StravaActivity createEntity(EntityManager em) {
        StravaActivity stravaActivity = new StravaActivity()
            .name(DEFAULT_NAME)
            .type(DEFAULT_TYPE)
            .description(DEFAULT_DESCRIPTION)
            .distance(DEFAULT_DISTANCE)
            .date(DEFAULT_DATE);
        return stravaActivity;
    }

    @Before
    public void initTest() {
        stravaActivity = createEntity(em);
    }

    @Test
    @Transactional
    public void createStravaActivity() throws Exception {
        int databaseSizeBeforeCreate = stravaActivityRepository.findAll().size();

        // Create the StravaActivity
        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isCreated());

        // Validate the StravaActivity in the database
        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeCreate + 1);
        StravaActivity testStravaActivity = stravaActivityList.get(stravaActivityList.size() - 1);
        assertThat(testStravaActivity.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testStravaActivity.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testStravaActivity.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testStravaActivity.getDistance()).isEqualTo(DEFAULT_DISTANCE);
        assertThat(testStravaActivity.getDate()).isEqualTo(DEFAULT_DATE);
    }

    @Test
    @Transactional
    public void createStravaActivityWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = stravaActivityRepository.findAll().size();

        // Create the StravaActivity with an existing ID
        stravaActivity.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isBadRequest());

        // Validate the StravaActivity in the database
        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = stravaActivityRepository.findAll().size();
        // set the field null
        stravaActivity.setName(null);

        // Create the StravaActivity, which fails.

        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isBadRequest());

        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = stravaActivityRepository.findAll().size();
        // set the field null
        stravaActivity.setType(null);

        // Create the StravaActivity, which fails.

        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isBadRequest());

        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDistanceIsRequired() throws Exception {
        int databaseSizeBeforeTest = stravaActivityRepository.findAll().size();
        // set the field null
        stravaActivity.setDistance(null);

        // Create the StravaActivity, which fails.

        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isBadRequest());

        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = stravaActivityRepository.findAll().size();
        // set the field null
        stravaActivity.setDate(null);

        // Create the StravaActivity, which fails.

        restStravaActivityMockMvc.perform(post("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isBadRequest());

        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllStravaActivities() throws Exception {
        // Initialize the database
        stravaActivityRepository.saveAndFlush(stravaActivity);

        // Get all the stravaActivityList
        restStravaActivityMockMvc.perform(get("/api/strava-activities?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(stravaActivity.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].distance").value(hasItem(DEFAULT_DISTANCE.doubleValue())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())));
    }

    @Test
    @Transactional
    public void getStravaActivity() throws Exception {
        // Initialize the database
        stravaActivityRepository.saveAndFlush(stravaActivity);

        // Get the stravaActivity
        restStravaActivityMockMvc.perform(get("/api/strava-activities/{id}", stravaActivity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(stravaActivity.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.distance").value(DEFAULT_DISTANCE.doubleValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingStravaActivity() throws Exception {
        // Get the stravaActivity
        restStravaActivityMockMvc.perform(get("/api/strava-activities/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStravaActivity() throws Exception {
        // Initialize the database
        stravaActivityService.save(stravaActivity);

        int databaseSizeBeforeUpdate = stravaActivityRepository.findAll().size();

        // Update the stravaActivity
        StravaActivity updatedStravaActivity = stravaActivityRepository.findOne(stravaActivity.getId());
        // Disconnect from session so that the updates on updatedStravaActivity are not directly saved in db
        em.detach(updatedStravaActivity);
        updatedStravaActivity
            .name(UPDATED_NAME)
            .type(UPDATED_TYPE)
            .description(UPDATED_DESCRIPTION)
            .distance(UPDATED_DISTANCE)
            .date(UPDATED_DATE);

        restStravaActivityMockMvc.perform(put("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedStravaActivity)))
            .andExpect(status().isOk());

        // Validate the StravaActivity in the database
        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeUpdate);
        StravaActivity testStravaActivity = stravaActivityList.get(stravaActivityList.size() - 1);
        assertThat(testStravaActivity.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testStravaActivity.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testStravaActivity.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testStravaActivity.getDistance()).isEqualTo(UPDATED_DISTANCE);
        assertThat(testStravaActivity.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingStravaActivity() throws Exception {
        int databaseSizeBeforeUpdate = stravaActivityRepository.findAll().size();

        // Create the StravaActivity

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restStravaActivityMockMvc.perform(put("/api/strava-activities")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stravaActivity)))
            .andExpect(status().isCreated());

        // Validate the StravaActivity in the database
        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteStravaActivity() throws Exception {
        // Initialize the database
        stravaActivityService.save(stravaActivity);

        int databaseSizeBeforeDelete = stravaActivityRepository.findAll().size();

        // Get the stravaActivity
        restStravaActivityMockMvc.perform(delete("/api/strava-activities/{id}", stravaActivity.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<StravaActivity> stravaActivityList = stravaActivityRepository.findAll();
        assertThat(stravaActivityList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StravaActivity.class);
        StravaActivity stravaActivity1 = new StravaActivity();
        stravaActivity1.setId(1L);
        StravaActivity stravaActivity2 = new StravaActivity();
        stravaActivity2.setId(stravaActivity1.getId());
        assertThat(stravaActivity1).isEqualTo(stravaActivity2);
        stravaActivity2.setId(2L);
        assertThat(stravaActivity1).isNotEqualTo(stravaActivity2);
        stravaActivity1.setId(null);
        assertThat(stravaActivity1).isNotEqualTo(stravaActivity2);
    }
}
