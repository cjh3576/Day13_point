package com.JH.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.JH.point.PointDTO;

public class PointView {
	public void view(String s) {
		System.out.println(s);
	}

	public void view(PointDTO dto) throws SQLException {
		System.out.println(" NUM :" + dto.getNum());
		System.out.println(" ID : " + dto.getSid());
		System.out.println(" 국어점수 : " + dto.getKor());
		System.out.println(" 영어점수 : " + dto.getEng());
		System.out.println(" 수학점수 : " + dto.getMath());
		System.out.println(" 총점 : " + dto.getTotal());
		System.out.println(" 평균점수 : " + dto.getAvg());
		System.out.println(" 반번호 : " + dto.getBnum());
		System.out.println("=========================");
	}

	public void view(ArrayList<PointDTO> ar) throws Exception {
		for(PointDTO dto : ar) {
			this.view(dto);
		}
	}
}
