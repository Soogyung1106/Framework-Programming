package org.kpu.di.persistence;

import org.kpu.di.domain.MemberVO;

public interface MemberDAO {
	public MemberVO read(String id) throws Exception;
	public void add(MemberVO student) throws Exception;
}
