package com.wesurf.wesurfweb.service;

import com.wesurf.wesurfweb.domain.StravaActivity;
import com.wesurf.wesurfweb.repository.StravaActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing StravaActivity.
 */
@Service
@Transactional
public class StravaActivityService {

    private final Logger log = LoggerFactory.getLogger(StravaActivityService.class);

    private final StravaActivityRepository stravaActivityRepository;

    public StravaActivityService(StravaActivityRepository stravaActivityRepository) {
        this.stravaActivityRepository = stravaActivityRepository;
    }

    /**
     * Save a stravaActivity.
     *
     * @param stravaActivity the entity to save
     * @return the persisted entity
     */
    public StravaActivity save(StravaActivity stravaActivity) {
        log.debug("Request to save StravaActivity : {}", stravaActivity);
        return stravaActivityRepository.save(stravaActivity);
    }

    /**
     * Get all the stravaActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<StravaActivity> findAll(Pageable pageable) {
        log.debug("Request to get all StravaActivities");
        return stravaActivityRepository.findAll(pageable);
    }

    /**
     * Get one stravaActivity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public StravaActivity findOne(Long id) {
        log.debug("Request to get StravaActivity : {}", id);
        return stravaActivityRepository.findOne(id);
    }

    /**
     * Delete the stravaActivity by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete StravaActivity : {}", id);
        stravaActivityRepository.delete(id);
    }
}
