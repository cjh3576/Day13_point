package com.JH.input;

import java.util.Scanner;

import com.JH.point.PointDTO;


public class PointInput {
	public PointDTO setPoint() {
		Scanner sc = new Scanner(System.in);
		PointDTO pointDTO = new PointDTO();

		System.out.println("학생번호 입력");
		pointDTO.setNum(sc.nextInt());
		System.out.println("ID 입력");
		pointDTO.setSid(sc.next());
		System.out.println("국어 점수 입력");
		pointDTO.setKor(sc.nextInt());
		System.out.println("영어 점수 입력");
		pointDTO.setEng(sc.nextInt());
		System.out.println("수학 점수 입력");
		pointDTO.setMath(sc.nextInt());
		System.out.println("반 번호 입력");
		pointDTO.setBnum(sc.nextInt());
		
		pointDTO.setTotal(pointDTO.getEng() + pointDTO.getKor() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		
		
		return pointDTO;
		
	}
	public int setNum(String string) {
		System.out.println("번호를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		return num;
	}
	
}
