package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.cctv;
import com.ssafy.happyhouse.service.CctvService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/cctv")
public class CctvController {
	
	@Autowired
	CctvService ser;

	/////////////////////////////////// 처음 시작할때 json file 파싱 해서 cctv 위치 db에 등록하기 /////////////////
	@PostMapping("regist")
	public void regist() {
		String file= "/src/main/resources/static/json/cctvdata.json";
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader( ResourceUtils.getFile("classpath:cctvdata.json")));
			
			JSONArray fields = (JSONArray) jsonObject.get("fields"); 
			JSONArray records = (JSONArray) jsonObject.get("records");
			List<cctv> list= new LinkedList<>();
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
			ser.regist(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/list")
	public List<cctv> list() {
		return ser.list();
	}
	
	@GetMapping("/search")
	public List<cctv> search(String name) {
		return ser.search(name);
	}
	
	/*@GetMapping("/direction")
	public List<cctv> direction(String name) {
		
		String urlstr = "";
		URL url;
		try {
			url = new URL(urlstr);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
			
			 JSONObject json = new JSONObject();
		        json.put("data", br);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ser.search(name);
	}*/
	
}
