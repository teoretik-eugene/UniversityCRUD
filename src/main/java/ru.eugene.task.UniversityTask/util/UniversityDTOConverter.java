package ru.eugene.task.UniversityTask.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.eugene.task.UniversityTask.dto.UniversityDTO;
import ru.eugene.task.UniversityTask.models.University;

import java.util.List;

@Component
public class UniversityDTOConverter {

    ModelMapper modelMapper;

    public UniversityDTOConverter() {
        modelMapper = new ModelMapper();
    }

    public UniversityDTO toDTO(University university){
        return this.modelMapper.map(university, UniversityDTO.class);
    }

    public University toUniversity(UniversityDTO universityDTO){
        return this.modelMapper.map(universityDTO, University.class);
    }

    public List<UniversityDTO> getDTOList(List<University> list){

        List<UniversityDTO> dtoList = list.stream()
                .map(t -> modelMapper.map(t, UniversityDTO.class)).toList();

        return dtoList;
    }
}
