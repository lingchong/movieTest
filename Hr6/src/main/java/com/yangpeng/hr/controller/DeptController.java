package com.yangpeng.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yangpeng.hr.mapper.Dept1Mapper;
import com.yangpeng.hr.model.Dept1;
@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	Dept1Mapper deptMapper;

	@GetMapping(
			value = "/{id}"
			)
	public Dept1 get(@PathVariable int id) {

		return deptMapper.load(id);
	}

	@GetMapping(
			value="",
			//consumes="application/json",
			produces="application/json"
			)
	public List<Dept1> list() {
		
		return deptMapper.list();
	}

}
