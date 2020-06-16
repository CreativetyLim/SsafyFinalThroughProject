package com.ssafy.happyhouse.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.HouseInfoDTO;
import com.ssafy.happyhouse.dto.SidoCodeDTO;
import com.ssafy.happyhouse.service.FSelectBoxService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/map.do")
public class FSelectBoxController extends HttpServlet {

   @Autowired
   private FSelectBoxService service;

   @GetMapping("/sido")
   public ResponseEntity<List<SidoCodeDTO>> sido() {
      ArrayList<SidoCodeDTO> list = service.selectSido();
      return new ResponseEntity<List<SidoCodeDTO>>(list, HttpStatus.OK);
   }
   @GetMapping("/gugun")
   public ResponseEntity<List<SidoCodeDTO>> gugun(String sido) {
      ArrayList<SidoCodeDTO> list = service.selectGugun(sido);
      return new ResponseEntity<List<SidoCodeDTO>>(list, HttpStatus.OK);
   
   }
   @GetMapping("/dong")
   public ResponseEntity<List<HouseInfoDTO>> dong(String gugun) {
      ArrayList<HouseInfoDTO> list = service.selectDong(gugun);
      return new ResponseEntity<List<HouseInfoDTO>>(list, HttpStatus.OK);

   }
      
   @GetMapping("/apt")
   public ResponseEntity<List<HouseInfoDTO>>  apt(String dong) {
      ArrayList<HouseInfoDTO> list = service.selectApt(dong);
      return new ResponseEntity<List<HouseInfoDTO>>(list, HttpStatus.OK);

   }
      

}