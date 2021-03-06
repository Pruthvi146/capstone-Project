package com.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.EventsRepository;
import com.info.exception.EventsNotFoundException;
import com.info.model.Events;

@Service
public class EventServiceImpl  implements EventService  {
	
	@Autowired
	private EventsRepository repo;
	
	public List<Events> listAll(){
		return (List<Events>) repo.findAll();
	}

	public void save(Events coup) {
		// TODO Auto-generated method stub
		repo.save(coup);
	}
	
	public Events get(Long Eid) throws EventsNotFoundException{
		Optional<Events> result = repo.findById(Eid);
		if(result.isPresent()) {
			return result.get();
		}
		throw new EventsNotFoundException("Could not find any event with Eid" +Eid);
		
	}
	
	public void delete(Long Eid) throws EventsNotFoundException{
		repo.deleteById(Eid);
	}

}

