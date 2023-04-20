package ru.eugene.task.UniversityTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eugene.task.UniversityTask.dto.UniversityDTO;
import ru.eugene.task.UniversityTask.models.University;
import ru.eugene.task.UniversityTask.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    // TODO: исправить getAll()

    public List<University> getAll(){
        return universityService.findAll();
    }

    @ResponseBody
    @GetMapping()
    public List<UniversityDTO> getAllUniversity(){
        return universityService.getAllUniversity();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addUniversity(@RequestBody UniversityDTO universityDTO){
        universityService.saveUniversity(universityDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public UniversityDTO getUniversityById(@PathVariable("id") int id){
        return universityService.getUniversityDTOById(id);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUniversityById(@PathVariable("id") int id){
        universityService.deleteUniversityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> updateUniversityById(@PathVariable("id") int id,
                                            @RequestBody UniversityDTO universityDTO){
        if(universityService.updateUniversityById(id, universityDTO))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
