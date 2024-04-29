package linad.JavaFraimworkSpringSem3_2.controllers;

import linad.JavaFraimworkSpringSem3_2.domain.User;
import linad.JavaFraimworkSpringSem3_2.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getUsers().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getUsers().getUsers().add(user);
        return "User added from body!";
    }

}
