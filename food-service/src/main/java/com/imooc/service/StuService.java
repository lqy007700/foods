package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {
    Stu getStuInfo(int id);

    void setStu();

    void updateStu(int id, String name);

    void delStu(int id);
}
