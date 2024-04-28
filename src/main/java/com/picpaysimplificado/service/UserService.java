package com.picpaysimplificado.service;

import com.picpaysimplificado.DTO.UserDTO;
import com.picpaysimplificado.entity.user.User;
import com.picpaysimplificado.entity.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo logista não está autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario não tem saldo suficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
       return this.usuarioRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public User createUser(UserDTO date) throws Exception {

        User newUser = new User(date);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.usuarioRepository.findAll();
    }

    public void saveUser(User user) {
        this.usuarioRepository.save(user);
    }
}
