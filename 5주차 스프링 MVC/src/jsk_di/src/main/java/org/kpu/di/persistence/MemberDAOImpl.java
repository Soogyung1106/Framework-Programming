package org.kpu.di.persistence;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kpu.di.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// BeanPropertyRowMapper를 사용할 경우 StudentVO 의 프로퍼티 명과 테이블 컬럼 명이 같아야 함
	// 그렇지 않을 경우는 RoWMapper 인터페이스를 구현해서 레코드를 StudentVO로 변환 처리
	// READ(R: 읽기)
	public StudentVO read(String id) throws Exception {
	
		StudentVO vo = null;
		try {
			vo = jdbcTemplate.queryForObject( 
				     "SELECT * FROM STUDENT WHERE ID=?"
		             , new BeanPropertyRowMapper<StudentVO>(StudentVO.class), id);
		}
		catch(EmptyResultDataAccessException e) {
			return vo;
		}
		return vo;   
	}
	
	
	// RoWMapper 인터페이스를 구현한 익명 클래스를 정의, 클래스내 mapRow() 추상 메서드를 정의 
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentlist = jdbcTemplate.query( 
		     "SELECT * FROM STUDENT", 
		     	new RowMapper<StudentVO>() {
		    	 	public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	 		StudentVO vo = new StudentVO();
		    	 		vo.setId(rs.getString("ID"));
		    	 		vo.setPasswd(rs.getString("PASSWD"));
		    	 		vo.setUsername(rs.getString("USERNAME"));
		    	 		vo.setSnum(rs.getString("SNUM"));
		    	 		vo.setDepart(rs.getString("DEPART"));
		    	 		vo.setMobile(rs.getString("MOBILE"));
		    	 		vo.setEmail(rs.getString("EMAIL"));
		    	 		return vo;
		    	 	}
             	}
		);
		return studentlist;
	}
	
	//CREATE(C: 생성)
	public void add(StudentVO vo) throws Exception {
		jdbcTemplate.update(
			"INSERT INTO STUDENT (ID, PASSWD, USERNAME, SNUM, DEPART, MOBILE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)"
			, vo.getId(), vo.getPasswd(), vo.getUsername(), vo.getSnum(), vo.getDepart(), vo.getMobile(), vo.getEmail());
	}
	
	//UPDATE(U: 수정)
	public void modify(String id, String columnName, StudentVO vo) throws Exception{
		

		if(columnName.equals("id")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET ID = ? WHERE ID = ?"
					, vo.getId(), id);
			
		}else if(columnName.equals("passwd")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET PASSWD = ? WHERE ID = ?"
					, vo.getPasswd(), id);
		}else if(columnName.equals("username")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET USERNAME = ? WHERE ID = ?"
					, vo.getUsername(), id);
		}else if(columnName.equals("snum")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET SNUM = ?  WHERE ID = ?"
					, vo.getSnum(), id);
		}else if(columnName.equals("depart")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET DEPART = ? WHERE ID = ?"
					, vo.getDepart(), id);
		}else if(columnName.equals("mobile")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET MOBILE = ? WHERE ID = ?"
					, vo.getMobile(), id);
		}else if(columnName.equals("email")) {
			jdbcTemplate.update(
					"UPDATE STUDENT SET EMAIL = ? WHERE ID = ?"
					, vo.getEmail(), id);
		}

	
		
	}
	
	
	//DELETE(D: 삭제)
	public void delete(String id) throws Exception {
		jdbcTemplate.update("DELETE FROM STUDENT WHERE ID=?", id);
	}
	
	
	
	
	
}
