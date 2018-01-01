package com.example.greendaouse.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/1 0001.
 */

@Entity
public class Student
{
    @Id(autoincrement = true)
    private Long id;
    public String name;
    public int age;
    public String sex;
    public String countid ;
    public String getCountid() {
        return this.countid;
    }
    public void setCountid(String countid) {
        this.countid = countid;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1571302530)
    public Student(Long id, String name, int age, String sex, String countid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.countid = countid;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
}
