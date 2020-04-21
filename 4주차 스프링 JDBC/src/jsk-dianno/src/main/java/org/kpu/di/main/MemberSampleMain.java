
package org.kpu.di.main;

import org.kpu.di.domain.MemberVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 jsk-dianno");

//		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MemberService memberService = (MemberService)ctx.getBean(MemberService.class);  // by Class name
//		MemberService memberService = (MemberService)ctx.getBean("memberService");  // by Component name 
		
		MemberVO vo = new MemberVO(); 
		
		vo.setId("soogyung"); vo.setPasswd("1234"); vo.setUsername("soogyung"); vo.setSnum("2017156037"); 
		vo.setDepart("소프트웨어(주)"); vo.setMobile("01090323040"); vo.setEmail("2017156037@kpu.ac.kr");
		memberService.addMember(vo); 
		MemberVO member = memberService.readMember("soogyung");
		
		
		System.out.println(member);
	}

}
