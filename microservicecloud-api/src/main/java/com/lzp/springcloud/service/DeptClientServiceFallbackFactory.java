package com.lzp.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lzp.springcloud.pojo.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 
 * @author Administrator
 * 
 * 实现服务降级
 *
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public boolean add(Dept dept) {
				return false;
			}

			@Override
			public Dept findById(Long id) {
				Dept dept = new Dept();
		        dept.setDeptNo(id);
		        dept.setDeptName("该ID" + id + "没有没有对应的信息,null--@HystrixCommand");
		        dept.setDbSource("no this database in MySQL");
		        return dept;
			}

			@Override
			public List<Dept> findAll() {
				return null;
			}
		};
	}

}
