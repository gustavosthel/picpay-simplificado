package com.picpaysimplificado.service;

import com.picpaysimplificado.entity.user.User;
import com.picpaysimplificado.entity.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    public void saveUser(User user) {
        this.usuarioRepository.save(user);
    }
}
