package id.go.project.Repository;

import id.go.project.Model.User;
import id.go.project.Model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,String> {
    UserLogin findByUserNameAndPassword(String userName, String password);
}
