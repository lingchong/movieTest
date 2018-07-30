package com.yangpeng.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangpeng.hr.model.Staff1;
import com.yangpeng.hr.service.HrService;
//@RestController
//控制器：接收 HTTP 请求，完成响应
@Controller
//控制器的 URL
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	HrService hrService;
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public Staff1 load(
			@PathVariable int id) {
		
		return hrService.loadStaff(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public String update(
			@PathVariable int id,
			Staff1 staff) {
		hrService.update(staff);
		System.out.println(staff);
		return "{msg: 'ok'}";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String remove(@PathVariable int id) {
		hrService.deleteStaff(id);
		return "{msg: "+id+"}";
	}
	

	@PostMapping
	@ResponseBody
	public String add(Staff1 s) {

		// Spring 框架中 IoC 容器： 繁琐的任务自动化
		// 自动完成了从请求参数到 Bean 的创建与组装
		
		System.out.println("post staff: " + s.getName());
		System.out.println("post staff: " + s.getJob());
		System.out.println("post staff: " + s.getEmail());
		
		hrService.addStaff(s);
	
		// 重定向到当前 GET
//		return "redirect:";
		
		// 返回状态码
		return "{msg: 'ok'}";
	}
	
	@GetMapping
	@ResponseBody
	public List<Staff1> list() {
		return hrService.listStaff();
	}
	
//	@GetMapping
//	@ResponseBody
//	public List<Staff1> list(){
//		
//	}
//	

	
	
	
}

