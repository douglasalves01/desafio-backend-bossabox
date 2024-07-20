package tech.desafio_backend_bossabox.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.desafio_backend_bossabox.entities.User;
import tech.desafio_backend_bossabox.services.UserService;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Gerencimento de usuários")

public class UserController{
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> salvar(User user){
        User item=userService.salvar(user);
        return ResponseEntity.ok(user);
    }
}
