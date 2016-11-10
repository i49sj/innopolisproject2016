package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import server.entity.Lesson;

/**
 * Created by innopolis on 10.11.16.
 */
@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
