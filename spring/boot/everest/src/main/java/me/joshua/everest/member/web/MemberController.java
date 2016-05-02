package me.joshua.everest.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping
	@ResponseBody
	public String hello() {
		return "NJU <img src=\"/image/nju.jpg\">";
	}
}
