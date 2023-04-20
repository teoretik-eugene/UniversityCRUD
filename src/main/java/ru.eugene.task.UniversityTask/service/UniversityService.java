package ru.eugene.task.UniversityTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.task.UniversityTask.dto.UniversityDTO;
import ru.eugene.task.UniversityTask.models.University;
import ru.eugene.task.UniversityTask.repository.UniversityRepository;
import ru.eugene.task.UniversityTask.util.UniversityDTOConverter;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository repository;
    private final UniversityDTOConverter universityDTOConverter;

    @Autowired
    public UniversityService(UniversityRepository repository, UniversityDTOConverter universityDTOConverter) {
        this.repository = repository;
        this.universityDTOConverter = universityDTOConverter;
    }

    public List<University> findAll(){
        return repository.findAll();
    }

    public void saveUniversity(UniversityDTO universityDTO){

        // TODO: можно будет сделать потом обработку ошибок

        University university = universityDTOConverter.toUniversity(universityDTO);

        repository.save(university);        // возвращает обновленную сущность
    }
    public UniversityDTO getUniversityDTOById(int id){
        Optional<University> optionalUniversity = repository.findById(id);

        if (optionalUniversity.isPresent()){
            University university = optionalUniversity.get();
            UniversityDTO universityDTO = universityDTOConverter.toDTO(university);
            return universityDTO;
        } else
            return new UniversityDTO();
    }

    public List<UniversityDTO> getAllUniversity(){
        return universityDTOConverter.getDTOList(repository.findAll());
    }

    public void deleteUniversityById(int id){
        Optional<University> optionalUniversity = repository.findById(id);

        if (optionalUniversity.isPresent()){
            repository.delete(optionalUniversity.get());
        }
    }

    public boolean updateUniversityById(int id, UniversityDTO universityDTO){
        University university = repository.getReferenceById(id);

        if(repository.findById(id).isPresent()){
            updateEntity(university, universityDTO);
            repository.save(university);
            return true;        // Если нашлась сущность с таким ID
        }else {
            return false;       // Если нет такой сущности для Update
        }
    }

    public University findByUniversityName(String name){
        return repository.findByNameEquals(name);
    }

    private void updateEntity(University university, UniversityDTO universityDTO) {

        /*Данный метод смотрит какие поля ему передали в JSON и модифицирует*/

        if(universityDTO.getName() != null)
            university.setName(universityDTO.getName());

        if(universityDTO.getAddress() != null)
            university.setAddress(universityDTO.getAddress());

        if(universityDTO.getFoundationYear() != 0)
            university.setFoundationYear(universityDTO.getFoundationYear());

        if(universityDTO.getWebsite() != null)
            university.setWebsite(universityDTO.getWebsite());
    }

    public UniversityDTO convertToUniversityDTO(University university){
        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setName(university.getName());
        universityDTO.setAddress(university.getAddress());
        universityDTO.setFoundationYear(university.getFoundationYear());
        universityDTO.setWebsite(university.getWebsite());
        return universityDTO;
    }

}
