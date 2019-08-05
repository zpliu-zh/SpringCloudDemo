package com.lzp.springcloud.controller;

import com.lzp.springcloud.pojo.Dept;
import com.lzp.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/add")
    public boolean add( Dept dept){
        return  deptClientService.add(dept);
    }
    @RequestMapping("/findById/{deptNo}")
    public Dept findById(@PathVariable("deptNo") Long deptNo){
        return deptClientService.findById(deptNo);
    }
    @RequestMapping("/findAll")
    public List<Dept> findAll(){
        return deptClientService.findAll();
    }

}
