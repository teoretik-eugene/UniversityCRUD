package ru.eugene.task.UniversityTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eugene.task.UniversityTask.models.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    public University findByNameIgnoreCase(String name);

    public University findByNameEquals(String name);

    public University findByNameLike(String name);
}
