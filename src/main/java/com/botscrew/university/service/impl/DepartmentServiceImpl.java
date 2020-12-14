package com.botscrew.university.service.impl;

import com.botscrew.university.model.Degree;
import com.botscrew.university.model.Lector;
import com.botscrew.university.repository.DepartmentRepository;
import com.botscrew.university.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
        long assistantsCount = departmentRepository.findByName(title).getLectors()
                .stream().filter(l->l.getDegree().equals(Degree.ASSISTANT)).count();
        long  associateProfessorsCount = departmentRepository.findByName(title).getLectors()
                .stream().filter(l->l.getDegree().equals(Degree.ASSOCIATE_PROFESSOR)).count();
        long professorsCount = departmentRepository.findByName(title).getLectors()
                .stream().filter(l->l.getDegree().equals(Degree.PROFESSOR)).count();
        return String.format("assistants - %d: " + "\n"+
                "associate professors - %d " + "\n" +
                "professors - %d", assistantsCount, associateProfessorsCount, professorsCount);
    }

    @Override
    public String getAverageSalary(@NotNull String title) {
        BigDecimal sumOfSalary = departmentRepository.findByName(title)
                .getLectors().stream()
                .map(Lector::getSalary)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal averageSalary = sumOfSalary.divide(BigDecimal.valueOf(getCountOfEmployee(title)), RoundingMode.HALF_UP);
        return String.format("The average salary of %s is %.2f", title, averageSalary);
    }

    @Override
    public int getCountOfEmployee(@NotNull String title) {
        return departmentRepository.findByName(title)
                .getLectors().size();
    }
}
