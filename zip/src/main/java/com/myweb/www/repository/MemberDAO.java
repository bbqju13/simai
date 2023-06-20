package com.myweb.www.repository;

import com.myweb.www.domain.MemberVO;

public interface MemberDAO {

	MemberVO getUser(String id);

	int insert(MemberVO mvo);

}
