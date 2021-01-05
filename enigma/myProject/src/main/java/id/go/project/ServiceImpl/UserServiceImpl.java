package id.go.project.ServiceImpl;

import id.go.project.DTO.AlamatDTO;
import id.go.project.DTO.LoginDto;
import id.go.project.DTO.UserDTO;
import id.go.project.Model.Alamat;
import id.go.project.Model.User;
import id.go.project.Model.UserLogin;
import id.go.project.Repository.AlamatRepository;
import id.go.project.Repository.UserLoginRepository;
import id.go.project.Repository.UserRepository;
import id.go.project.Service.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlamatRepository alamatRepository;

    @Autowired
    UserLoginRepository userLoginRepository;


    public static boolean isValidEmail(String email) {
        // create the EmailValidator instance
        EmailValidator validator = EmailValidator.getInstance();

        // check for valid email addresses using isValid method
        return validator.isValid(email);
    }

    @Override
    @Transactional
    public Optional<User> tambahuser(UserDTO userDto) {
     try {
        boolean valid= isValidEmail(userDto.getEmail());
        System.out.println(valid+"valid ga");
         List<AlamatDTO> cekAlamat = userDto.getAlamatDTOS();
         if (userDto.getEmail().equals("") || userDto.getNama().equals("") || userDto.getTelp().equals("") || userDto.getAlamatDTOS().isEmpty()||valid==false) {
             return null;

         } else {
             for(AlamatDTO cek:cekAlamat) {
                 if (cek.getAlamat().equals("")){
                     return null;
                 }
             }
             String id = UUID.randomUUID().toString();
             String idAlamat = UUID.randomUUID().toString();
             User user = new User();
             user.setUserId(id);
             user.setNama(userDto.getNama());
             user.setEmail(userDto.getEmail());

             user.setTelp(userDto.getTelp());
             userRepository.save(user);
//             UserLogin userLogin = new UserLogin();
//             userLogin.setUserId(id);
//             userLogin.setUserName(userDto.getUserLogin().getUserName());
//             userLogin.setPassword(userDto.getUserLogin().getPassword());
//             userLoginRepository.save(userLogin);
             List<AlamatDTO> alamats = userDto.getAlamatDTOS();
             List<Alamat> addData = new ArrayList<>();
             for (AlamatDTO alamat1 : alamats) {
                 Alamat alamat2 = new Alamat();
                 alamat2.setUserId(id);
                 alamat2.setAlamat(alamat1.getAlamat());
                 addData.add(alamat2);
             }
             System.out.println(addData);
             alamatRepository.saveAll(addData);

             Optional<User> data = userRepository.findById(id);
             return data;

         }

   }catch (NullPointerException e){
         return null;
   }
 }

    @Override
    public List<User> getAllUser() {
        List<User> data = userRepository.findAll();
        return data;
    }

    @Override
    public List<User> getByName(String nama) {
        List<User> data = userRepository.getByNama(nama);
        return data;
    }

    @Override
    public UserLogin Login(String userName,String password) {
        UserLogin data = userLoginRepository.findByUserNameAndPassword(userName,password);
        if (data!=null){
            return data;
        }else{
            return null;
        }

    }

    @Transactional
    @Override
    public void deleteByUserId(String userId) {
        userRepository.deleteByUserId(userId);
    }
}
