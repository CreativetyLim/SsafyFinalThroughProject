package com.ssafy.happyhouse.dto;


public class cctv {
	String roadName;
	String lat;
	String lon;
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	@Override
	public String toString() {
		return "cctv [roadName=" + roadName + ", roadNumber=" + ", lat=" + lat + ", lon=" + lon + "]";
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	
	
}