package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {
	private int id;
    private String address_code;
    private int user_id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String apartment;
    private String address;
    private int country_id;
    private int state_id;
    private int city_id;
    private String zipcode;
    private Object lat;
    private Object lng;
    @JsonProperty("default") 
    private int mydefault;
    private String status;
    private String address_type;
    private String created_at;
    private String updated_at;
    private String city;
    private String state;
    private String country;
    private int is_selected;
	public int getId() {
		return id;
	}
	public String getAddress_code() {
		return address_code;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public String getApartment() {
		return apartment;
	}
	public String getAddress() {
		return address;
	}
	public int getCountry_id() {
		return country_id;
	}
	public int getState_id() {
		return state_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public String getZipcode() {
		return zipcode;
	}
	public Object getLat() {
		return lat;
	}
	public Object getLng() {
		return lng;
	}
	public int getMydefault() {
		return mydefault;
	}
	public String getStatus() {
		return status;
	}
	public String getAddress_type() {
		return address_type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public int getIs_selected() {
		return is_selected;
	}
    
}
