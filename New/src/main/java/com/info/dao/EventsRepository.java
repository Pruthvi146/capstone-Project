package com.info.dao;

import org.springframework.data.repository.CrudRepository;

import com.info.model.Events;

public interface EventsRepository extends CrudRepository<Events, Long> {

}
