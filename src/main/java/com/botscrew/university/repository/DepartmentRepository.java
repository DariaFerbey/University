package com.botscrew.university.repository;

import com.botscrew.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value="select * from departments where title=?1",nativeQuery = true)
    Department findByName(String name);

    @Query(value = "select count(l.degree) from lectors l" +
            " inner join department_lectors dl on l.id=dl.lector_id" +
            " inner join departments d on dl.department_id=d.id and title=?1 and degree='ASSISTANT'",nativeQuery = true)
    int findAssistantsCount(String title);

    @Query(value = "select count(l.degree) from lectors l" +
            " inner join department_lectors dl on l.id=dl.lector_id" +
            " inner join departments d on dl.department_id=d.id and title=?1 and degree='ASSOCIATE_PROFESSOR'",nativeQuery = true)
    int findAssociateProfessorsCount(String title);

    @Query(value = "select count(l.degree) from lectors l" +
            " inner join department_lectors dl on l.id=dl.lector_id" +
            " inner join departments d on dl.department_id=d.id and title=?1 and degree='PROFESSOR'",nativeQuery = true)
    int findProfessorsCount(String title);

    @Query(value = "select avg(l.salary) from lectors l" +
            " inner join department_lectors dl on l.id=dl.lector_id" +
            " inner join departments d on dl.department_id=d.id and title=?1", nativeQuery = true)
    double findAverageSalary(String title);

    @Query(value = "select count(distinct l.id) from lectors l" +
            " inner join department_lectors dl on l.id=dl.lector_id" +
            " inner join departments d on dl.department_id=d.id and title=?1",nativeQuery = true)
    int findNumberOfEmployee(String name);


}
