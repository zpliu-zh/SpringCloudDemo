package com.lzp.springcloud.service;

import com.lzp.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> List();

}
