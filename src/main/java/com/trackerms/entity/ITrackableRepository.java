package com.trackerms.entity;

import com.trackerms.models.Trackable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackableRepository extends CrudRepository<Trackable, Long> {
}
