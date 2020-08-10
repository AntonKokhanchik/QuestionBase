package questionbase.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.AnswerEntity;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<AnswerEntity, Long> {

}
