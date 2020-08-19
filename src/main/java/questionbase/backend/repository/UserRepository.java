package questionbase.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import questionbase.backend.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}
