package com.JH.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.JH.util.DBConnector;


public class PointDAO {


	public ArrayList<PointDTO> selectList() throws Exception {
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		Connection con = DBConnector.getConnect();
		PointDTO dto = null;
		String sql = "select * from point order by num desc";

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {

			dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setSid(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setBnum(rs.getInt("bnum"));
			
			ar.add(dto);
		}

		DBConnector.disConnect(rs, st, con);
		return ar;

	}
	public PointDTO selectOne(int num) throws Exception {
		PointDTO dto = null;
		Connection con = DBConnector.getConnect();

		String sql = "select * from point where num = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();

		if(rs.next()) {
			dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setSid(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setBnum(rs.getInt("bnum"));
		}

		DBConnector.disConnect(rs, st, con);

		return dto;


	}
	public int insert(PointDTO pointDTO) throws Exception {
		int result = 0;

		Connection con = DBConnector.getConnect();

		String sql = "insert into point values(?,?,?,?,?,?,?,?) ";
		PreparedStatement st = con.prepareStatement(sql);


		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());

		result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		return result;
	}

	public int delete(int num) throws Exception {
		int result = 0;
		Connection con = DBConnector.getConnect();
		String sql = "Delete Point where num = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		return result;

	}
}
