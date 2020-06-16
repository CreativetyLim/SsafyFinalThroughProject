package com.ssafy.happyhouse.service;


import java.util.ArrayList;

import com.ssafy.happyhouse.dto.HouseInfoDTO;
import com.ssafy.happyhouse.dto.SidoCodeDTO;


public interface FSelectBoxService {

   SidoCodeDTO selectUserSido(String sido);
   
   ArrayList<SidoCodeDTO> selectSido();
   ArrayList<SidoCodeDTO> selectGugun(String sido) ;
   ArrayList<HouseInfoDTO> selectDong(String gugun) ;
   ArrayList<HouseInfoDTO> selectApt(String dong) ;

}