//테스트 케이스 작성

package org.kpu.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //테스트용 DI 컨테이너를 동작시키기 위한 Runner 클래스
@ContextConfiguration(locations= "classpath:/applicationContext.xml") //테스트용 DI 컨테이너가 사용하는 설정 파일

public class MemberTest {
	
	@Autowired
	MemberService memberService; //DI 컨테이너에 등록할 테스트 대상 빈을 주입
	
	@Test //테스트 메서드 선언
	public void testReadMember() throws Exception{
		StudentVO member = memberService.readMember("soogyung"); //테스트 메서드 실행
		System.out.println(member);
	}
	
	
}
