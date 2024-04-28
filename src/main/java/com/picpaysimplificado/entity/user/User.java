package com.picpaysimplificado.entity.user;

import com.picpaysimplificado.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO date) {

        this.firstname = date.firstName();
        this.lastname = date.lastName();
        this.userType = date.userType();
        this.document = date.document();
        this.email = date.email();
        this.password = date.password();
        this.balance = date.balance();
    }
}
