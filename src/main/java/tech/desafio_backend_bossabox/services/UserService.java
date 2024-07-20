package tech.desafio_backend_bossabox.services;

import org.springframework.stereotype.Service;
import tech.desafio_backend_bossabox.entities.User;
import tech.desafio_backend_bossabox.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User salvar(User user){
        return userRepository.save(user);
    }
}
