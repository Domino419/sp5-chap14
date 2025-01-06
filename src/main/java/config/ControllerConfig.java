package config;

import controller.ChangePwdController;       // 250106 추기
import controller.LogoutController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.LoginController;      // 250102 추기
import spring.ChangePasswordService;    // 250106 추기
import spring.MemberRegisterService;
import spring.AuthService; // 250102 추기

/**
 * class         : ControllerConfig
 * date          : 24-12-08
 * description   : 컨트롤러를 스프링 빈으로 등록하는 설정 클래스
 */
@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;  // 회원 등록 서비스를 주입받는 필드

	@Autowired
	private AuthService authService;             // 로그인 검증을 위한 서비스를 주입받는 필드

	@Autowired
	private ChangePasswordService changePasswordService;

	private static final Log log = LogFactory.getLog(RegisterController.class);  // log

	/**
	 * method        : registerController
	 * date          : 24-12-26
	 * return        : RegisterController - 회원 등록 기능 컨트롤러 객체
	 */
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}

	/**
	 * method        : loginController
	 * date          : 25-01-02
	 * return        : LoginController - 로그인 기능 컨트롤러
	 */
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}

	/**
	 * method        : logoutController
	 * date          : 25-01-02
	 * return        : LogoutController - 로그아웃 기능 컨트롤러
	 */
	@Bean
	public LogoutController logoutController() {
		log.info(":::::::::::::::::::::::::::::::::: ControllerConfig.LogoutController ");
		return new LogoutController();
	}

	/**
	 * method        : changePwdController
	 * date          : 25-01-02
	 * return        : ChangePwdController - 비밀번호 변경 처리 컨트롤러
	 */
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}

}
