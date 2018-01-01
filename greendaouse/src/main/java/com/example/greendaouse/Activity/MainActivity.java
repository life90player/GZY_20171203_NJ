package com.example.greendaouse.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.greendaouse.Bean.Student;
import com.example.greendaouse.GreenDaoPackage.GreenDaoUtils;
import com.example.greendaouse.GreenDaoPackage.com.example.greendaouse.StudentDao;
import com.example.greendaouse.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    StudentDao studentDao;
    private List<Student> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDao=GreenDaoUtils.getSingleTon().getmDaoSession().getStudentDao();
        Student student = new Student();
        studentDao.insert(student);
        studentDao.insertInTx(mlist);
    }
}
