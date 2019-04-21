package github.nkor.repositories;

import github.nkor.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u" +
            " left join fetch u.roles r" +
            " left join fetch r.permissions" +
            " where u.email = :email")
    User findUserWithPermissions(@Param("email") String email);
}
