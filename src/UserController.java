package com.pro.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping("/userlogin")
public String Userlogin() {
	return "userlogin";
}
	@GetMapping("/userregistration")
	public String Register() {
		return "userregister";
}
	
/*
 * @PostMapping("/submituser") public ModelAndView Submituser(User obj) {
 * ModelAndView mv = new ModelAndView(); mv.addObject("name", obj.name);
 * mv.setViewName("Demo.jsp"); return mv; }
 */
	
}
