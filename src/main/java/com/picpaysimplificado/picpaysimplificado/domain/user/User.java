package com.picpaysimplificado.picpaysimplificado.domain.user;

import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "TB_USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document; // we are creating a user physical person (CPF) and legal person (CNPJ)

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal userBalance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    // Constructor to create the UserDTO
    public User(UserDTO userDTO){
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.userBalance = userDTO.balance();
        this.userType = userDTO.userType();
        this.password = userDTO.password();
        this.document = userDTO.document();
        this.email = userDTO.email();
    }
}
