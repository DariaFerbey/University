package com.botscrew.university.service;


public interface DepartmentService {
    String getHeadByTitle(String title);

    String getStatistic(String title);

    String getAverageSalary(String title);

    int getCountOfEmployee(String title);

}
