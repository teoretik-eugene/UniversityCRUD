package ru.eugene.task.UniversityTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.task.UniversityTask.dto.FacultyDTO;
import ru.eugene.task.UniversityTask.dto.PostFacultyDTO;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.repository.FacultyRepository;
import ru.eugene.task.UniversityTask.repository.UniversityRepository;
import ru.eugene.task.UniversityTask.mapper.FacultyMapper;
import ru.eugene.task.UniversityTask.util.FacultyDTOConverter;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final UniversityService universityService;
    private final FacultyMapper facultyMapper;
    private final FacultyDTOConverter facultyDTOConverter;

    @Autowired
    public FacultyService(FacultyRepository repository, UniversityRepository universityRepository, UniversityService universityService, FacultyMapper facultyMapper, FacultyDTOConverter facultyDTOConverter){
        this.facultyRepository = repository;
        this.universityRepository = universityRepository;
        this.universityService = universityService;
        this.facultyMapper = facultyMapper;
        this.facultyDTOConverter = facultyDTOConverter;
    }

    public List<FacultyDTO> getAllFaculty(){
        return facultyDTOConverter.getDTOList(facultyRepository.findAll());
    }

    public FacultyDTO findFacultyById(int id){
        Optional<Faculty> faculty =  facultyRepository.findById(id);
        if(faculty.isPresent()){
            return convertFacultyToDTO(faculty.get());
        }
        return null;
    }

    public Faculty addFaculty(PostFacultyDTO postFacultyDTO){
        Faculty faculty = facultyDTOConverter.postMapper(postFacultyDTO);
        facultyRepository.save(faculty);
        return faculty;
    }

    public boolean deleteFaculty(int id){
        if(facultyRepository.findById(id).isPresent()) {
            facultyRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    public boolean updateFaculty(int id, PostFacultyDTO postFacultyDTO){
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if(optionalFaculty.isPresent()){

            Faculty faculty = optionalFaculty.get();
            updateEntity(faculty, postFacultyDTO);
            facultyRepository.save(faculty);
            return true;

        }else
            return false;

    }

    public void updateEntity(Faculty faculty, PostFacultyDTO postFacultyDTO){
        if(postFacultyDTO.getName() != null)
            faculty.setName(postFacultyDTO.getName());

        if(postFacultyDTO.getCode() != null)
            faculty.setCode(postFacultyDTO.getCode());

        if(postFacultyDTO.getGpa() != 0)
            faculty.setGpa(postFacultyDTO.getGpa());

        if(postFacultyDTO.getDescription() != null)
            faculty.setDescription(postFacultyDTO.getDescription());

        if(faculty.getUniversity() != null)
            faculty.setUniversity(universityRepository.
                    findByNameEquals(postFacultyDTO.getUniversityName()));
    }

    public FacultyDTO convertFacultyToDTO(Faculty faculty){
        FacultyDTO facultyDTO = new FacultyDTO(faculty);
        facultyDTO.setUniversity(universityService.convertToUniversityDTO(faculty.getUniversity()));
        return facultyDTO;
    }
}
