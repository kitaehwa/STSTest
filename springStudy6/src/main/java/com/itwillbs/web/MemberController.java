package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
// => 특정 동작의 형태를 구분 (~.me, ~.bo, ~.do)
public class MemberController {
	
	// 객체 주입
//	@Inject
//	private MemberDAO mdao;
	@Inject
	private MemberService mService;
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);	

	// http://localhost:8088/web/test => X
	// http://localhost:8088/web/member/test => '/web'에서 '/' 로 변경
	// http://localhost:8088/member/test
//	@RequestMapping(value = "/test",method = RequestMethod.GET)
//	public void test() {
//		logger.debug("test() 실행");
//	}
	
	// 회원가입 - 정보입력
	// http://localhost:8088/member/join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinMemberGet() {
		logger.debug("/join -> joinMemberGet() 실행");
		logger.debug("연결된 뷰(JSP)를 보여주기");
		// 페이지 이동(X) => 스프링이 자동으로 연결
		logger.debug("/views/member/join.jsp 뷰페이지 연결");
	} 
	
	// 회원가입 - 정보처리
	@RequestMapping(value ="/join", method =RequestMethod.POST)
	public String joinMemberPost(MemberVO vo) {
		logger.debug("/member/join -> joinMemberPost() 실행");
		
		// 한글 인코딩처리
		// => web.xml 필터로 처리
		
		// 전달정보(파라메터) 저장
		logger.debug("vo : "+vo);
		
		// DB 객체 생성 - 회원가입
		// MemberDAO 객체 생성 => 객체 주입
		mService.memberJoin(vo);
		logger.debug("회원가입 성공!");
		logger.debug("로그인 페이지로 이동 /member/login");
		
		return "redirect:/member/login";
	}
	
	// 로그인 처리 - 입력(GET)
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginMemberGET() {
		logger.debug("/member/login -> loginMemberGET() 실행");
		logger.debug("연결된 뷰페이지(JSP) 출력");
		return "/member/loginForm"; // /views/member/loginForm
	}
	
	// 로그인 처리 - 처리(POST)
	@RequestMapping(value="/login", method = RequestMethod.POST)
	//public String loginMemberPOST(@RequestPart("userid") String userid,
								  //@ModelAttribute("userpw") String userpw) {
		public String loginMemberPOST(MemberVO vo, HttpSession session) {

		logger.debug("/member/login(post) -> loginMemberPOST() 실행");
		
		// 전달정보를 저장(userid, userpw)
		logger.debug("vo : "+vo);
		//logger.debug("userid : "+userid);
		//logger.debug("userpw : "+userpw);
		
		// 서비스 -> 회원정보 확인 -> DAO 호출
		MemberVO resultVO = mService.memberLoginCheck(vo);
		
		if(resultVO == null) {
			// 로그인 실패! 로그인 페이지로 이동
			return "redirect:/member/login";
		}
			// 사용자의 아이디정보를 세션 영역에 저장
			session.setAttribute("id", resultVO.getUserid());
			
			// 로그인 성공! 메인 페이지로 이동
		
			return "redirect:/member/main";
	}
	





}
