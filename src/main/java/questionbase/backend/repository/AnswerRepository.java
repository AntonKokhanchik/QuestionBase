package questionbase.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.AnswerEntity;

@Repository
public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {

}
