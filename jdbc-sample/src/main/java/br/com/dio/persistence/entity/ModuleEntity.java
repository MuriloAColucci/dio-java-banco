package br.com.dio.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class ModuleEntity {

    private long id;
    private String name;
    private List<EmployeeEntity> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
