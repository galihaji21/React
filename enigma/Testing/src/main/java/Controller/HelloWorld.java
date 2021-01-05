package Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @PostMapping("/inputNilai")
    public String addValue() {
        DataNilaiEntity newValue = dataNilaiService.addStudentValue(dataNilai);
        return new ResponseEntity<>(newValue, HttpStatus.OK);
    }
}
