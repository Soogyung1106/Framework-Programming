package org.kpu.di.persistence;

import java.util.List;

import org.kpu.di.domain.StudentVO;

public interface MemberDAO {
	//CRUD 함수들 선언  -> 구체적 구현은 MemberDAOImpl.java에서  
	public void add(StudentVO student) throws Exception; //CREATE
	public void delete(String id) throws Exception; //DELETE
	public void modify(String id, String columnName, StudentVO student) throws Exception; //UPDATE
	public StudentVO read(String id) throws Exception; //READ 
	
	public List<StudentVO> readList() throws Exception;
	
}
