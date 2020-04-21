package org.kpu.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")

public class MemberTest {
	
	@Autowired
	MemberService memberService;
	
	//테스트 케이스1
	//@Test 
	public void testAddMember( ) throws Exception { //addMember() 함수 테스트
		String strID = "test";
		StudentVO vo = new StudentVO(); 
		vo.setId(strID); 
		vo.setPasswd(strID);  
		vo.setUsername(strID); 
		vo.setSnum(strID);
		vo.setDepart(strID);
		vo.setEmail(strID);
		vo.setMobile(strID);
		memberService.addMember(vo); //테스트 메서드 실행
		StudentVO member = memberService.readMember("test");
		System.out.println(member);
	}
	
	//테스트 케이스2
	@Test
	public void testReadMember( ) throws Exception { //readMember() 함수 테스트 
		StudentVO member = memberService.readMember("test"); //테스트 메서드 실행
		System.out.println(member);
	}
}
