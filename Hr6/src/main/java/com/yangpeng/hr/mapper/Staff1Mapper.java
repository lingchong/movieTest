package com.yangpeng.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yangpeng.hr.model.Dept1;
import com.yangpeng.hr.model.Staff1;

@Mapper
public interface Staff1Mapper {
	
//	查询
	@Select("select id,name ,email,phone,job,dept from staff1")
	List<Staff1> findAll();
	


	
	@Delete("delete from staff1 where id = #{id}")
	void remove(int id);
	
//  插入
	@Insert("insert into staff1( name ,job,email,phone) values(#{name},#{job},#{email},#{phone}")
	void create(Staff1 s);
	
	@Select("select * from staff1 where id =#{id}")
	@Results(value= {
			@Result(property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="job", column="job"),
			@Result(property="email", column="email"),
			@Result(property="phone", column="phone"),
			@Result(
					property="dept", 
					column="dept",
					javaType=Dept1.class,
					one=@One(select="loadDeptById")
					)
	})
	Staff1 load(int id);
	
	@Select("select * from dept1 where dept_id=#{id}")
	@Results(value= {
			@Result(column="dept_id", property="id"),
			@Result(column="dept_title", property="title"),
			@Result(column="dept_loc", property="loc")
	})
	Dept1 loadDeptById(int id);
	
	
	@Update("update staff set name = #{name},job=#{job}, phone=#{phone}, email=#{email},dept=#{id} where id=#{id}")
	void update(Staff1 s);
	

}
