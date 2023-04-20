package ru.eugene.task.UniversityTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eugene.task.UniversityTask.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    public Faculty findByNameLike(String name);
}
