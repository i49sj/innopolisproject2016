package ru.innopolis.studentproject.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.studentproject.server.entity.Student;

/**
 * Created by User on 09.11.2016.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
