
package org.kpu.di.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner; //scan 객체 사용 목적

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------------");
		System.out.println("학생 정보 관리 프로그램");
		System.out.println("------------------");
	
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name
		
		
		while(true) {
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 수정");
			System.out.println("5. 개인 학생 정보 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.println("------------------");
			
			System.out.println("select >> ");
			
			try {
				//사용자에게 숫자 입력 받기 (Scanner 클래스 사용)
				Scanner scan = new Scanner(System.in);
				int sel = scan.nextInt(); 
				scan.nextLine();
				
				switch(sel) {
				
				case 1: //전체 학생 정보 출력  OK
					System.out.println();
					try {
						List<StudentVO> list = memberService.readMemberList();
						for(StudentVO svo : list) {  
							System.out.println(svo);
						}
					} catch(DataAccessException e) {
						System.out.println(e);
					} //end catch
					
					break;
				case 2: //개인 학생 정보 출력  OK
					System.out.print("id 입력: ");
					String strID = scan.nextLine(); //입력 받기
					try {
						
						StudentVO member = memberService.readMember(strID); 
						
						//예외처리
						if(member == null) {
							System.out.println("존재하지 않는 id입니다.");
							break;
						}
						
					} catch(DataAccessException e) {
						System.out.println(e);
						
					}//end catch
					
					break;
				case 3: //개인 학생 정보 생성 OK
					try {
						
						StudentVO vo = new StudentVO(); //새로운 객체를 담을 vo
						
						System.out.print("id 입력: ");
						String id = scan.nextLine(); //입력 받기
						vo.setId(id);
						
						System.out.print("pswd 입력: ");
						String pswd = scan.nextLine(); //입력 받기
						vo.setPasswd(pswd);
						
						System.out.print("username 입력: ");
						String username = scan.nextLine(); //입력 받기
						vo.setUsername(username);
						
						System.out.print("snum 입력: ");
						String snum = scan.nextLine(); //입력 받기
						vo.setSnum(snum);
						
						System.out.print("depart 입력: ");
						String depart = scan.nextLine(); //입력 받기
						vo.setDepart(depart);
						
						System.out.print("mobile 입력: ");
						String mobile = scan.nextLine(); //입력 받기
						vo.setMobile(mobile);
						
						System.out.print("email 입력: ");
						String email = scan.nextLine(); //입력 받기
						vo.setEmail(email);
						
						memberService.addMember(vo);
						
						
					} catch(DataAccessException e) {
						System.out.println(e);
						
					}//end catch
					
					break;
				case 4: //개인 학생 정보 수정
					
					StudentVO vo = new StudentVO(); //새로운 객체를 담을 vo
					String id4U=null;
					
					
					System.out.println("수정하고 싶은 학생의 id를 입력: ");
					id4U = scan.nextLine(); //입력 받기
					
					//예외처리	
					StudentVO member = memberService.readMember(id4U); 
					if (member == null){
						System.out.println("존재하지 않는 id입니다.");
						break;
					}
				
					
					System.out.println("수정하고 싶은  db 컬럼명 입력: ");
					String columnName = scan.nextLine();
					System.out.println("수정하고 싶은 값으로 입력: ");
					String changeValue = scan.nextLine();
					
					if( columnName.equals("id")) {
						vo.setId(changeValue);
					}else if(columnName.equals("passwd")==true) {
						vo.setPasswd(changeValue);					
					}else if(columnName.equals("username")==true) {
						vo.setUsername(changeValue);
					}else if(columnName.equals("snum")==true) {
						vo.setSnum(changeValue);
					}else if(columnName.equals("depart")==true) {
						vo.setDepart(changeValue);
					}else if(columnName.equals("mobile")==true) {
						vo.setMobile(changeValue);
					}else if(columnName.equals("email")==true) {
						vo.setEmail(changeValue);
					}else { //예외처리
						System.out.println("존재하지 않은 컬럼명입니다.");
						break;
					}
					
					try {
						
						memberService.modifyMember(id4U, columnName, vo); //해당 컬럼를 값을 수정  
						
					} catch(DataAccessException e) {
						System.out.println(e);
						
					}//end catch
					
					
					break;
					
				case 5: //개인 학생 정보 삭제  OK
					System.out.print("id 입력: ");
					String strID4D = scan.nextLine(); //입력 받기
					
					//예외처리	
					StudentVO member4check = memberService.readMember(strID4D); 
					if (member4check == null){
						System.out.println("존재하지 않는 id입니다.");
						break;
					}
					
					try {
						memberService.deleteMember(strID4D); //해당 id를 가진 열 삭제  
						
					} catch(DataAccessException e) {
						System.out.println(e);
						
					}//end catch
					break;
				case 6: //프로그램 종료 OK
					System.out.println("안녕히 가세요.");
					return ; //프로그램 아예 종료 
					
				}
			}catch(InputMismatchException e){ //OK
				System.out.println("확인 후 입력하세요.");
				continue;
			}
			
		}//end while
		
		
		
	
	}//end main

}
