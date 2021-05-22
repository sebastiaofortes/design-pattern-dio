package com.sebastiaofortes.security.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {

		return "index";
	}
	
	@RequestMapping("/sobre")
	public String sobre() {

		return "sobre";
	}
	
}
