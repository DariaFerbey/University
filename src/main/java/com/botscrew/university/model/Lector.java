package com.botscrew.university.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.EAGER)
    private List<Department> departments;

    public Lector() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void seName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
