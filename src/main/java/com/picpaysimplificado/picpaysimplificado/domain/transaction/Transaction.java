package com.picpaysimplificado.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "TB_TRANSACTIONS")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private BigDecimal transactionAmount;

    @ManyToOne // a user can have multiple transactions, but a transaction has one user
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne // a user can have multiple transactions, but a transaction has one user
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;
}
