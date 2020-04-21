package org.kpu.di.service;

import org.kpu.di.domain.MemberVO;

public interface MemberService {
		public MemberVO readMember(String id) throws Exception;
		public void addMember(MemberVO student) throws Exception;
}
