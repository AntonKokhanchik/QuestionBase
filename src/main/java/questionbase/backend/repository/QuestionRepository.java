package questionbase.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.QuestionEntity;

import java.util.List;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository <QuestionEntity, Long> {
    @Override
    List<QuestionEntity> findAll();
}
