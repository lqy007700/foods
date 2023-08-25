package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    public StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void setStu() {
        Stu stu = new Stu();
        stu.setName("feng");
        stu.setAge(32);
        stuMapper.insert(stu);
    }

    @Override
    public void updateStu(int id, String name) {
//        stuMapper.updateByPrimaryKey()

    }

    @Override
    public void delStu(int id) {

    }
}
