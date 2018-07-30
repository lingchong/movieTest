package com.yangpeng.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangpeng.hr.mapper.Dept1Mapper;
import com.yangpeng.hr.mapper.Staff1Mapper;
import com.yangpeng.hr.model.Dept1;
import com.yangpeng.hr.model.Staff1;
@Service
public class HrService {
	@Autowired
	Dept1Mapper deptMapper;

	@Autowired
	Staff1Mapper staffMapper;

	// 复杂：调用多个数据操作
	// @Transactional
	// public void transfer(Staff from, Staff to, int n) {
	// // 往交易记录表插入一条数据
	// staffMapper.update(from);
	// staffMapper.update(to);
	// }

	/**
	 * 业务逻辑只是简单调用了数据操作
	 * 
	 * @return
	 */
	public void update(Staff1 s) {
	staffMapper.update(s);
		
	}
	public List<Staff1> listStaff() {
		return staffMapper.findAll();
	}

	public void deleteStaff(int id) {
		staffMapper.remove(id);
	}
	
	public void addStaff(Staff1 s) {
		staffMapper.create(s);
	}
	
	public Staff1 loadStaff(int id) {
		return staffMapper.load(id);
	}
}
	