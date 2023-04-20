package ru.eugene.task.UniversityTask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.models.University;

import javax.persistence.*;
import java.util.List;

public class UniversityDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("foundation_year")
    private int foundationYear;
    @JsonProperty("website")
    private String website;

    public UniversityDTO() {
    }

    public UniversityDTO(String name, String address, int foundationYear, String website) {
        this.name = name;
        this.address = address;
        this.foundationYear = foundationYear;
        this.website = website;
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
}
