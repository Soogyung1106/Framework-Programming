package org.kpu.di.persistence;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import org.kpu.di.domain.MemberVO;

@Component
public class MemberDAOImpl implements MemberDAO {
	
	private Map<String, MemberVO> storage = new HashMap<String, MemberVO>();
	
	public MemberVO read(String id) throws Exception {
		return storage.get(id);  
	}
	public void add(MemberVO student) throws Exception { 
		storage.put(student.getId(), student);
	}
}
