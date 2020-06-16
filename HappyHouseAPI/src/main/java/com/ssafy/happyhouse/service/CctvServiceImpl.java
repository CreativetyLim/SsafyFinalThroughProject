package com.ssafy.happyhouse.service;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.CctvDAO;
import com.ssafy.happyhouse.dto.cctv;

@Service
public class CctvServiceImpl implements CctvService{

	@Autowired
	CctvDAO dao;
	String file = "";
	
	@Override
	public void regist(List<cctv> list) {
		// TODO Auto-generated method stub
		for(int i=0; i <list.size(); i++) {
			dao.regist(list.get(i).getRoadName(), list.get(i).getLat(), list.get(i).getLon());
		}
	}

	@Override
	public List<cctv> list() {
		
		if(true)
		return dao.list();
		file= "cctvdata.json";
		List<cctv> list= new LinkedList<>();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
			
			JSONArray fields = (JSONArray) jsonObject.get("fields"); 
			JSONArray records = (JSONArray) jsonObject.get("records");
			
			cctv tv ;
			for(int i=0; i<records.size(); i++) {
				tv = new cctv();
				JSONObject tmp = (JSONObject) records.get(i);
				tv.setLat((String) tmp.get("위도"));
				tv.setLon((String) tmp.get("경도"));
				tv.setRoadName((String) tmp.get("소재지도로명주소"));
				if(tv.getRoadName()==null) {
					tv.setRoadName((String) tmp.get("소재지지번주소"));
				}
				
				if(tv.getRoadName().contains("서울특별시")) {
					list.add(tv);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<cctv> search(String name) {
		// TODO Auto-generated method stub
		file= "cctvdata.json";
		file="";
		List<cctv> list= new LinkedList<>();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
			
			JSONArray fields = (JSONArray) jsonObject.get("fields"); 
			JSONArray records = (JSONArray) jsonObject.get("records");
			
			cctv tv ;
			for(int i=0; i<records.size(); i++) {
				tv = new cctv();
				JSONObject tmp = (JSONObject) records.get(i);
				tv.setLat((String) tmp.get("위도"));
				tv.setLon((String) tmp.get("경도"));
				tv.setRoadName((String) tmp.get("소재지도로명주소"));
				if(tv.getRoadName()==null) {
					tv.setRoadName((String) tmp.get("소재지지번주소"));
				}
				
				if(tv.getRoadName().contains("서울특별시") && tv.getRoadName().contains(name)) {
					list.add(tv);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
