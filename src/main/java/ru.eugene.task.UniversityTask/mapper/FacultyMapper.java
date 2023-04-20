package ru.eugene.task.UniversityTask.mapper;

import org.springframework.stereotype.Component;
import ru.eugene.task.UniversityTask.dto.PostFacultyDTO;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.repository.FacultyRepository;
import ru.eugene.task.UniversityTask.repository.UniversityRepository;

@Component
public class FacultyMapper {

    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    public FacultyMapper(FacultyRepository facultyRepository, UniversityRepository universityRepository) {
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
    }


    public Faculty postMapper(PostFacultyDTO postFacultyDTO){
        Faculty faculty = new Faculty();

        faculty.setName(postFacultyDTO.getName());
        faculty.setCode(postFacultyDTO.getCode());
        faculty.setGpa(postFacultyDTO.getGpa());
        faculty.setDescription(postFacultyDTO.getDescription());
        faculty.setUniversity(universityRepository.findByNameEquals(postFacultyDTO.getUniversityName()));

        return faculty;
    }
}
