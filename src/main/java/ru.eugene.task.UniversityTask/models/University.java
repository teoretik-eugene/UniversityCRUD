package ru.eugene.task.UniversityTask.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "University")
public class University {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "foundation_year")
    private int foundationYear;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "university")
    private List<Faculty> faculties;

    public University() {
    }

    public University(String name, String address, int foundationYear, String website) {
        this.name = name;
        this.address = address;
        this.foundationYear = foundationYear;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "{ " + this.id + ": " + this.name + ", " + this.address + ", " + this.foundationYear +
                 " - " + this.website + " }";
    }
}
