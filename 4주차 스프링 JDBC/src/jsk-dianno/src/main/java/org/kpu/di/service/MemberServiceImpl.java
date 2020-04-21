package org.kpu.di.service;

import org.kpu.di.domain.MemberVO;
import org.kpu.di.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired 
	private MemberDAO memberDAO;
			
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	/*
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	*/
	
	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	
	public void addMember(MemberVO student) throws Exception {
		memberDAO.add(student);
	}

}
