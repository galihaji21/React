package id.go.project.Controller;

import id.go.project.DTO.UserDTO;
import id.go.project.Model.User;
import id.go.project.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/User")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(description = "USER")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Post User")
    public ResponseEntity PostUser(@RequestBody UserDTO userDTO) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        Optional<User> data = userService.tambahuser(userDTO);
        if (data==null){
            res.put("status","true");
            res.put("message","data belum lengkap");
            return ResponseEntity.badRequest().body(res);
        }else {
            res.put("status","true");
            res.put("message","sukses");
            res.put("data",data);
            return ResponseEntity.ok().body(res);
        }


    }

   @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation("user get All")
        public ResponseEntity UserGetAll() {
            LinkedHashMap<String, Object> res = new LinkedHashMap<>();
            List<User> data = userService.getAllUser();
            res.put("status", "true");
            res.put("message", "sukses");
            res.put("data", data);
            return ResponseEntity.ok().body(res);
    }


    @GetMapping(path = "/getByName/{nama}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("user get By Name")
    public ResponseEntity UserGetByName(@PathVariable String nama) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        List<User> data = userService.getByName(nama);
        res.put("status", "true");
        res.put("message", "sukses");
        res.put("data", data);
        return ResponseEntity.ok().body(res);
    }

}
