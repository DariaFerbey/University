package com.botscrew.university.repository;

import com.botscrew.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector,Long> {

    @Query(value ="select l.first_name from lectors l where l.first_name like %:template%" ,nativeQuery = true)
    List<String> globalSearchByTemplate(@Param("template") String template);

}
