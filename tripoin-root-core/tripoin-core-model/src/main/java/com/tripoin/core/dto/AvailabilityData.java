package com.tripoin.core.dto;

import com.tripoin.core.pojo.Availability;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class AvailabilityData {

	private int id;
	private String name;
	
	public AvailabilityData() {}	

	public AvailabilityData(Availability availability) {
		super();
		this.id = availability.getId();
		this.name = availability.getName();
	}

	public AvailabilityData(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AvailabilityData [id=" + id + ", name=" + name + "]";
	}
	
}
