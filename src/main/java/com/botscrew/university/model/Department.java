package com.botscrew.university.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name = "head_of_department", nullable = false)
    private String headOfDepartment;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinTable(
            name="department_lectors",
            joinColumns = @JoinColumn(name = "department_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id")
    )
    private List<Lector> lectors;

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headOfDepartment='" + headOfDepartment + '\'' +
                ", lectors=" + lectors +
                '}';
    }
}
