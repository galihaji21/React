package id.go.project.ServiceImpl;

import id.go.project.DTO.AlamatDTO;
import id.go.project.DTO.UserDTO;
import id.go.project.Model.Alamat;
import id.go.project.Model.User;
import id.go.project.Repository.AlamatRepository;
import id.go.project.Repository.UserRepository;
import id.go.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlamatRepository alamatRepository;

    @Override
    @Transactional
    public Optional<User> tambahuser(UserDTO userDto) {
     try {
         List<AlamatDTO> cekAlamat = userDto.getAlamatDTOS();
         if (userDto.getEmail().equals("") || userDto.getNama().equals("") || userDto.getTelp().equals("") || userDto.getAlamatDTOS().isEmpty()) {
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
}
