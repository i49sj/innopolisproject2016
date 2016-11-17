package ru.innopolis.studentproject.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.studentproject.server.entity.Lesson;

/**
 * Created by innopolis on 10.11.16.
 */
@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
