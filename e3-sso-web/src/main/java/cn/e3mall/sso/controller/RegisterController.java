package cn.e3mall.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.RegisterService;
import xn.e3mall.common.utils.E3Result;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/page/register")
	public String showRegister(){
		
		return "register";
	}

	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public E3Result checkData(@PathVariable String param,@PathVariable Integer type){
		E3Result data = registerService.checkData(param, type);
		return data;
	}
	
	@RequestMapping(value="/user/register")
	@ResponseBody
	public E3Result register(TbUser user){
		System.out.println("-------");
		E3Result result = registerService.register(user);
		
		return result;
	}
	
}
