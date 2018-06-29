package com.wesurf.wesurfweb.repository;

import com.wesurf.wesurfweb.domain.StravaActivity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the StravaActivity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StravaActivityRepository extends JpaRepository<StravaActivity, Long> {

}
