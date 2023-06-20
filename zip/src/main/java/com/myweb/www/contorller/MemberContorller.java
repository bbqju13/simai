package com.myweb.www.contorller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberContorller {
	private static final Logger log = LoggerFactory.getLogger(MemberContorller.class);
	
	@Autowired
	private MemberService msv;
	
	@GetMapping("/signup")
	public String index(Model m) {
		log.info(" >>>>> HOME 접근 완료 >>>>>");
		m.addAttribute("msg_home", 1);
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signUpPost(Model m, MemberVO mvo) {
		log.info(" >>>>> 회원가입 접근완료 >>>>> ");
		log.info(" >>>>> 회원가입 >>>>> : "+ mvo.toString());
		int isOk = msv.signUp(mvo);
		if(isOk > 0) {
			m.addAttribute(" >>>>> msg_signUp", 1);
		}else {
			m.addAttribute(" >>>>> msg_signUp", 0);
		}
		return "home";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model m, String id, String pw, HttpServletRequest req) {

		log.info(" >>>>> ID >>>>> : " + id + "," + " >>>>> PW >>>>> : " + pw);
		
		MemberVO isUser = msv.isUser(id, pw);
		if(isUser != null) {
			HttpSession ses = req.getSession();
			ses.setAttribute("ses", isUser); // 세션에 객체 담기
			ses.setMaxInactiveInterval(60*10); // 로그인 유지시간
			
			m.addAttribute("user", isUser);
			m.addAttribute("msg_login", 1);
		}else {
			m.addAttribute("msg_login", 0);
		}
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(Model m, HttpServletRequest req) {
		req.getSession().removeAttribute("ses");
		req.getSession().invalidate(); // 세션끊기
		m.addAttribute("msg_logout", 1);
		return "home";
	}
	
}