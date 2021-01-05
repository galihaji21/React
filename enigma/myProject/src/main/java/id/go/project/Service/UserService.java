package id.go.project.Service;

import id.go.project.DTO.LoginDto;
import id.go.project.DTO.UserDTO;
import id.go.project.Model.User;
import id.go.project.Model.UserLogin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface UserService {
    Optional<User> tambahuser(UserDTO user);

    List<User> getAllUser();

    List<User> getByName(String nama);

    UserLogin Login(String userName, String password);

    void deleteByUserId(String userId);
}
