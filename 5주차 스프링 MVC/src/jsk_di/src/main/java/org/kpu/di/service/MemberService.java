package org.kpu.di.service;

import java.util.List;

import org.kpu.di.domain.StudentVO;

public interface MemberService {
	public StudentVO readMember(String id) throws Exception; //READ 
	public void addMember(StudentVO student) throws Exception; //CREATE
	public void deleteMember(String id) throws Exception; //DELETE
	public void modifyMember(String id, String columnName, StudentVO student) throws Exception; //UPDATE
	
	public List<StudentVO> readMemberList() throws Exception;

}
