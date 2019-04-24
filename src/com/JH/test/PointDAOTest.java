package com.JH.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import com.JH.point.PointDAO;
import com.JH.point.PointDTO;

public class PointDAOTest {

	//@Test
	public void test() throws Exception {
		PointDAO pointdao = new PointDAO();
		PointDTO pointdto = new PointDTO();

		int result = pointdao.delete(1);
		assertEquals(1, result);

	}
	//@Test
	public void test1() throws Exception {
		PointDAO pointdao = new PointDAO();
		PointDTO dto =pointdao.selectOne(1);
		assertNotNull(dto);
	}
	//@Test
	public void test2() throws Exception{
		PointDAO dao = new PointDAO();
		ArrayList<PointDTO> dto = dao.selectList();
		assertNotEquals(0, dto.size());
	}
	@Test
	public void test3() throws Exception {
		PointDAO dao = new PointDAO();
		Random r = new Random();
		for(int i =0; i<100 ;i++) {
			PointDTO dto = new PointDTO();
			int num = 1;
			dto.setNum(num+1);
			dto.setSid("jh"+i);
			dto.setKor(r.nextInt(101));
			dto.setEng(r.nextInt(101));
			int result = dao.insert(dto);
		}
		//			assertEquals(1, result);
	}
}

