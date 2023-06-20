package com.myweb.www.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberDAO mdao;

	@Autowired
	BCryptPasswordEncoder Pwencoder;

	@Override
	public int signUp(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> 회원가입 서비스 진입 >>>>> : {}");
		MemberVO tmpUser = mdao.getUser(mvo.getId());
		if (tmpUser != null) {
			return 0;
		}
		if (mvo.getPw() == null || mvo.getPw().length() == 0) {
			return 0;
		}
		String pw = mvo.getPw();
		String encoPw = Pwencoder.encode(pw);
		mvo.setPw(encoPw);
		;
		int isOk = mdao.insert(mvo);
		return isOk;
	}

	@Override
	public MemberVO isUser(String id, String pw) {
		// TODO Auto-generated method stub
		log.info(" >>>>> 로그인 서비스 진입 >>>>> : {} ");
		MemberVO user = mdao.getUser(id);
		if (user == null) {
			return null;
		}
		if (Pwencoder.matches(pw, user.getPw())) {
			return user;
		} else {
			return null;
		}
	}

}
