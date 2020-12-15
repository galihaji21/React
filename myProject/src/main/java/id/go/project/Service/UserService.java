package id.go.project.Service;

import id.go.project.DTO.UserDTO;
import id.go.project.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface UserService {
    Optional<User> tambahuser(UserDTO user);

    List<User> getAllUser();

    List<User> getByName(String nama);
}
