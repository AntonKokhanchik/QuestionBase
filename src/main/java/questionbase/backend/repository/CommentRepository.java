package questionbase.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.CommentEntity;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<CommentEntity, Long> {

}
