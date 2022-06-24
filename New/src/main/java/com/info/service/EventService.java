package com.info.service;

import java.util.List;

import com.info.exception.EventsNotFoundException;
import com.info.model.Events;

public interface EventService {
	public List<Events> listAll();
	public void save(Events coup);
	public Events get(Long Eid) throws EventsNotFoundException;
	public void delete(Long Eid) throws EventsNotFoundException;
}
