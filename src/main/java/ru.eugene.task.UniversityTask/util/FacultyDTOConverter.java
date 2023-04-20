package ru.eugene.task.UniversityTask.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.eugene.task.UniversityTask.dto.FacultyDTO;
import ru.eugene.task.UniversityTask.dto.PostFacultyDTO;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.service.UniversityService;

import java.util.List;

@Component
public class FacultyDTOConverter {

    private final UniversityService universityService;

    private ModelMapper modelMapper;

    @Autowired
    public FacultyDTOConverter(UniversityService service) {
        modelMapper = new ModelMapper();
        this.universityService = service;
    }

    public FacultyDTO toDTO(Faculty faculty){
        return modelMapper.map(faculty, FacultyDTO.class);
    }

    public List<FacultyDTO> getDTOList(List<Faculty> list){
        return list.stream().map(t -> modelMapper.map(t, FacultyDTO.class)).toList();
    }

    public Faculty postMapper(PostFacultyDTO postFacultyDTO){
        Faculty faculty = new Faculty();

        faculty.setName(postFacultyDTO.getName());
        faculty.setCode(postFacultyDTO.getCode());
        faculty.setGpa(postFacultyDTO.getGpa());
        faculty.setDescription(postFacultyDTO.getDescription());
        faculty.setUniversity(universityService.findByUniversityName(postFacultyDTO.getUniversityName()));

        return faculty;
    }

}
