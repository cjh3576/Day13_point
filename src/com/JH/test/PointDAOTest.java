package com.JH.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	@Test
	public void test2() throws Exception{
		PointDAO dao = new PointDAO();
		ArrayList<PointDTO> dto = dao.selectList();
		assertNotEquals(0, dto.size());
	}
}
