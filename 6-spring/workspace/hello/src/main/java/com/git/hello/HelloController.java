package com.git.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller + @ResponseBody = @RestController
//@Controller: HTTP ��û�� ���� ������ ó���� �� �ִ� Ŭ����
//ResponseBody: Controller�ε� �������� ������ ��ü�� ó����
@RestController
public class HelloController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello, Spring Boot!";
	}
}
