package com.wesurf.wesurfweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.wesurf.wesurfweb.domain.StravaActivity;
import com.wesurf.wesurfweb.service.StravaActivityService;
import com.wesurf.wesurfweb.web.rest.errors.BadRequestAlertException;
import com.wesurf.wesurfweb.web.rest.util.HeaderUtil;
import com.wesurf.wesurfweb.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing StravaActivity.
 */
@RestController
@RequestMapping("/api")
public class StravaActivityResource {

    private final Logger log = LoggerFactory.getLogger(StravaActivityResource.class);

    private static final String ENTITY_NAME = "stravaActivity";

    private final StravaActivityService stravaActivityService;

    public StravaActivityResource(StravaActivityService stravaActivityService) {
        this.stravaActivityService = stravaActivityService;
    }

    /**
     * POST  /strava-activities : Create a new stravaActivity.
     *
     * @param stravaActivity the stravaActivity to create
     * @return the ResponseEntity with status 201 (Created) and with body the new stravaActivity, or with status 400 (Bad Request) if the stravaActivity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/strava-activities")
    @Timed
    public ResponseEntity<StravaActivity> createStravaActivity(@Valid @RequestBody StravaActivity stravaActivity) throws URISyntaxException {
        log.debug("REST request to save StravaActivity : {}", stravaActivity);
        if (stravaActivity.getId() != null) {
            throw new BadRequestAlertException("A new stravaActivity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StravaActivity result = stravaActivityService.save(stravaActivity);
        return ResponseEntity.created(new URI("/api/strava-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /strava-activities : Updates an existing stravaActivity.
     *
     * @param stravaActivity the stravaActivity to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated stravaActivity,
     * or with status 400 (Bad Request) if the stravaActivity is not valid,
     * or with status 500 (Internal Server Error) if the stravaActivity couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/strava-activities")
    @Timed
    public ResponseEntity<StravaActivity> updateStravaActivity(@Valid @RequestBody StravaActivity stravaActivity) throws URISyntaxException {
        log.debug("REST request to update StravaActivity : {}", stravaActivity);
        if (stravaActivity.getId() == null) {
            return createStravaActivity(stravaActivity);
        }
        StravaActivity result = stravaActivityService.save(stravaActivity);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stravaActivity.getId().toString()))
            .body(result);
    }

    /**
     * GET  /strava-activities : get all the stravaActivities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of stravaActivities in body
     */
    @GetMapping("/strava-activities")
    @Timed
    public ResponseEntity<List<StravaActivity>> getAllStravaActivities(Pageable pageable) {
        log.debug("REST request to get a page of StravaActivities");
        Page<StravaActivity> page = stravaActivityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/strava-activities");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /strava-activities/:id : get the "id" stravaActivity.
     *
     * @param id the id of the stravaActivity to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the stravaActivity, or with status 404 (Not Found)
     */
    @GetMapping("/strava-activities/{id}")
    @Timed
    public ResponseEntity<StravaActivity> getStravaActivity(@PathVariable Long id) {
        log.debug("REST request to get StravaActivity : {}", id);
        StravaActivity stravaActivity = stravaActivityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(stravaActivity));
    }

    /**
     * DELETE  /strava-activities/:id : delete the "id" stravaActivity.
     *
     * @param id the id of the stravaActivity to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/strava-activities/{id}")
    @Timed
    public ResponseEntity<Void> deleteStravaActivity(@PathVariable Long id) {
        log.debug("REST request to delete StravaActivity : {}", id);
        stravaActivityService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
