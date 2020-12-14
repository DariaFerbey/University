package com.botscrew.university;

import com.botscrew.university.service.DepartmentService;
import com.botscrew.university.service.LectorService;
import com.botscrew.university.view.MyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LectorService lectorService;


    @Override
    public void run(String... args) throws Exception {
        new MyView(departmentService,lectorService).show();
    }
}
