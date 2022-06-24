package com.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Eid;
	
	public Long getEid() {
		return Eid;
	}

	public void setEid(Long eid) {
		this.Eid = eid;
	}

	@Column(nullable=false, unique=true, length=45)
	private String eventName;
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventName() {
		return eventName;
	}

	@Column(nullable=false)
	private String startDate;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(nullable=false)
	private String endDate;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

	@Override
	public String toString() {
		return "Coupons{"+"Eid="+Eid+", Event Name="+eventName+'\''+"Start Date="+startDate+'\''+"End Date="+endDate+'\''+ '}';
	}
}
