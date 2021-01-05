package id.go.project.Repository;

import id.go.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> getByUserId(String userId);

    @Query("Select u from User u where u.nama like %:nama%")
    List<User> getByNama(@PathVariable String nama);
    
    @Modifying
    @Query("delete from User u where u.userId =:userId")
    void deleteByUserId(String userId);
}
