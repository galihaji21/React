package id.go.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
@Table(name="user")
public class User {
    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="nama")
    private String nama;
    @Column(name="telp")
    private String telp;
    @Column(name="email")
    private String email;

}
