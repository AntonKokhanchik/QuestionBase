package questionbase.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.QuestionEntity;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository <QuestionEntity, Long> {

}
