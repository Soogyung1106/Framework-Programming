package org.kpu.web.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.kpu.web.domain.StudentVO;
import org.kpu.web.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MockMemberServcie implements MemberService {
	private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();
	
    @PostConstruct
    public void init() {
		StudentVO vo = new StudentVO(); 
		vo.setId("soogyung"); vo.setPasswd("1234");  vo.setUsername("soogyung"); vo.setSnum("2017156037");
		vo.setDepart("소프트웨어"); vo.setMobile("010-1234-1234"); vo.setEmail("soogyung@kpu.ac.kr");
		
		StudentVO vo2 = new StudentVO(); 
		vo2.setId("sg"); vo2.setPasswd("4321");  vo2.setUsername("sg"); vo2.setSnum("2017156038");
		vo2.setDepart("소프트웨어"); vo2.setMobile("010-4321-4321"); vo2.setEmail("sg@kpu.ac.kr");
		
		try {
			addMember( vo ); 
			addMember( vo2);
		}catch(Exception e) {
			System.out.println(e);
		}
    }

	@Override
	public StudentVO readMember(String id) throws Exception {
		// TODO Auto-generated method stub
		if(storage.get(id) ==  null) throw new DataNotFoundException(id);
		return storage.get(id);
	}

	@Override
	public void addMember(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		storage.put(student.getId(), student);
	}

	@Override
	public List<StudentVO> readMemberList() throws Exception {
		// TODO Auto-generated method stub
        List<StudentVO> list = new LinkedList<StudentVO>();
        for (StudentVO customer : storage.values()) {
            list.add(customer);
        }
        return list;
	}

	@Override
	public void updateMember(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
		if(storage.get(student.getId()) !=  null) {
			storage.remove(student.getId());
		}
		storage.put(student.getId(), student);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		storage.remove(id);
	}
}
