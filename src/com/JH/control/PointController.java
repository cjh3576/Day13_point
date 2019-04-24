package com.JH.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.JH.input.PointInput;
import com.JH.point.PointDAO;
import com.JH.point.PointDTO;
import com.JH.view.PointView;

public class PointController {
	private Scanner sc;
	private PointInput pi;
	private PointDAO pd;
	private PointView pv;
	private ArrayList<PointDTO> ar;
	
	public PointController() {
		sc = new Scanner(System.in);
		pi = new PointInput();
		pd = new PointDAO();
		pv = new PointView();
		ar = new ArrayList<PointDTO>();
	}
	
	public void start() throws Exception {
		PointDTO pointDTO = null;
		boolean check = true;
		int num;
		while(check) {
			System.out.println("1. 점수 추가     2.   정보 삭제     3.  정보 번호 조회   4. 정보 전체조회    5. 종료");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				pointDTO = pi.setPoint();
				int nu = pd.getnum();
				pointDTO.setNum(nu+1);
				int result = pd.insert(pointDTO);
				
				String message = "등록실패";
				if(result>0) {
				message = "등록성공";
				ar.add(pointDTO);
				}
				pv.view(message);
				break;
			case 2:
				int n =pi.setNum("삭제");
				pd.delete(n);
				String message2 = "삭제실패";
				if(n>0) {
					message2 = "삭제 성공";
				}
				pv.view(message2);
				break;
			case 3:
				n = pi.setNum("조회");
				pointDTO = pd.selectOne(n);
				if(pointDTO != null) {
				pv.view(pointDTO);
				} else {
					pv.view("없는 번호");
				}
				
				break;
			case 4: 
				ar = pd.selectList();
				pv.view(ar);
				break;
			default :
				check = !check;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
