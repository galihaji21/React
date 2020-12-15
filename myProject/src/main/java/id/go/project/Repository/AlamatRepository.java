package id.go.project.Repository;

import id.go.project.DTO.AlamatDTO;
import id.go.project.Model.Alamat;
import id.go.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AlamatRepository  extends CrudRepository<Alamat, Serializable> {
}
