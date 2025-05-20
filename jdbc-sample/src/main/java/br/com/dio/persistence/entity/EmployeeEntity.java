package br.com.dio.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class EmployeeEntity {
    private long id;
    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;
    private List<ContactEntity> contacts;
    private List<ModuleEntity> modules;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }
}
