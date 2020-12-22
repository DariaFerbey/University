package com.botscrew.university.service.impl;

import com.botscrew.university.repository.DepartmentRepository;
import com.botscrew.university.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadByTitle(@NotNull String title) {
        String head = departmentRepository.findByName(title).getHeadOfDepartment();

        return String.format("Head of %s department is %s",title,head);
    }

    @Override
    public String getStatistic(@NotNull String title) {
        int assistantsCount=departmentRepository.findAssistantsCount(title);
        int associateProfessorsCount=departmentRepository.findAssociateProfessorsCount(title);
        int professorsCount=departmentRepository.findProfessorsCount(title);

        return String.format("assistants - %d: " + "\n"+
                "associate professors - %d " + "\n" +
                "professors - %d", assistantsCount, associateProfessorsCount, professorsCount);
    }

    @Override
    public String getAverageSalary(@NotNull String title) {
        BigDecimal averageSalary = BigDecimal.valueOf(departmentRepository.findAverageSalary(title));

        return String.format("The average salary of %s is %.2f", title, averageSalary);
    }

    @Override
    public int getCountOfEmployee(@NotNull String title) {
        return departmentRepository.findNumberOfEmployee(title);
    }
}
