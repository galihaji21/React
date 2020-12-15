package id.go.project.DTO;


import id.go.project.Model.Alamat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String nama;
    private String telp;
    private String email;
    private List<AlamatDTO>alamatDTOS;
}
