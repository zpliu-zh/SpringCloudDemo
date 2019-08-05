package com.lzp.springcloud.service.impl;

import com.lzp.springcloud.dao.DeptMapper;
import com.lzp.springcloud.pojo.Dept;
import com.lzp.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        int count = deptMapper.insert(dept);
        if (count > 0)
            return true;
        else
            return false;
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> List() {
        return deptMapper.selectByExample(null);
    }
}
