package ru.eugene.task.UniversityTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eugene.task.UniversityTask.dto.FacultyDTO;
import ru.eugene.task.UniversityTask.dto.PostFacultyDTO;
import ru.eugene.task.UniversityTask.models.Faculty;
import ru.eugene.task.UniversityTask.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @ResponseBody
    @GetMapping
    public List<FacultyDTO> getAllFaculty(){
        return facultyService.getAllFaculty();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public FacultyDTO findFacultyById(@PathVariable("id") int id){
        return facultyService.findFacultyById(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addFaculty(@RequestBody PostFacultyDTO postDto){
        facultyService.addFaculty(postDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFaculty(@PathVariable("id") int id){
        if (facultyService.deleteFaculty(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> updateFaculty(@PathVariable("id")int id,
                                                    @RequestBody PostFacultyDTO postDto){
        if(facultyService.updateFaculty(id, postDto))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
