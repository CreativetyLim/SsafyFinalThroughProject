package com.ssafy.happyhouse.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseInfoDTO;
import com.ssafy.happyhouse.dto.SidoCodeDTO;


@Mapper
public interface FSelectBoxDAO {

   
   SidoCodeDTO selectUserSido(String sido);
   
   ArrayList<SidoCodeDTO> selectSido()  ;

   ArrayList<SidoCodeDTO> selectGugun(String sido)  ;

   ArrayList<HouseInfoDTO> selectDong(String gugun)  ;

   ArrayList<HouseInfoDTO> selectApt(String dong)  ;

}