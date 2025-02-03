package com.rishit.h2_jpa_hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {

    private @Id long id;
    private @Column(name="name") String name;
    private @Column(name="vendor") String vendor;

    public Courses() {}

    public Courses(long id, String name, String vendor) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
