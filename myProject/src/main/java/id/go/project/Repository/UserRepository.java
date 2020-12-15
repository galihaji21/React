package id.go.project.Repository;

import id.go.project.Model.Alamat;
import id.go.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> getByUserId(String userId);

    List<User> getByNama(String nama);
}
