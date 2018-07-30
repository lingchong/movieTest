package com.yangpeng.hr.mapper;
import org.apache.ibatis.annotations.Many;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yangpeng.hr.model.Dept1;
import com.yangpeng.hr.model.Staff1;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
@Mapper
public interface Dept1Mapper {
	
	@Select("select * from dept1")
	@Results(value= {
			@Result(property="id", column="dept_id"),
			@Result(property="title", column="dept_title"),
			@Result(property="loc", column="dept_loc"),
			@Result(
					property="staffList",
					column="dept_id",
					javaType=List.class,
					many=@Many(select="findStaffByDept")
					)
	})
	List<Dept1> list();

	@Select("select * from dept1 where dept_id=#{id}")
	@Results(value= {
			@Result(column="dept_id", property="id", javaType=Integer.class),
			@Result(column="dept_title", property="title", javaType=String.class),
			@Result(column="dept_loc", property="loc"),
			@Result(
					property="staffList",
					javaType=List.class,
					column="dept_id",
					many=@Many(select="findStaffByDept")
					)
	})
	Dept1 load(int id);
	
	/**
	 * 获得特定部门的所有员工信息
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from staff1 where dept=#{id}")
	List<Staff1> findStaffByDept(int id);
	
	

}
