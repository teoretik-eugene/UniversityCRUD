package ru.eugene.task.UniversityTask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.models.University;

public class FacultyDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("gpa")
    private float gpa;
    @JsonProperty("description")
    private String description;
    @JsonProperty("university")
    private UniversityDTO university;

    public FacultyDTO() {
    }

    public FacultyDTO(Faculty faculty){
        this.name = faculty.getName();
        this.code = faculty.getCode();
        this.description = faculty.getDescription();
        this.gpa = faculty.getGpa();
        // TODO не хватает здесь universityDTO
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }
}
