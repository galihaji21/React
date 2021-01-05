package id.go.project.Controller;


import id.go.project.DTO.LoginDto;
import id.go.project.DTO.UserDTO;
import id.go.project.Model.User;
import id.go.project.Model.UserLogin;
import id.go.project.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/v1/UserLogin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(description = "USER Login")
public class UserLoginController {

    @Autowired
    UserService userService;

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "login")
    public ResponseEntity PostUser(@RequestBody LoginDto loginDto) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        UserLogin data = userService.Login(loginDto.getUserName(),loginDto.getPassword());
        if (data==null){
            res.put("status","true");
            res.put("message","user atau password salah");
            return ResponseEntity.badRequest().body(res);
        }else {
            res.put("status","true");
            res.put("message","sukses");
            res.put("data",data);
            return ResponseEntity.ok().body(res);
        }


    }

}
