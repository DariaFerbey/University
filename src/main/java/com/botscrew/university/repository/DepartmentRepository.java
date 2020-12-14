package com.botscrew.university.repository;

import com.botscrew.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value="select * from departments where title=?1",nativeQuery = true)
    Department findByName(String name);
}
