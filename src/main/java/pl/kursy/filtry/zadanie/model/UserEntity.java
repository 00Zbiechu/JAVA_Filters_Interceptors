package pl.kursy.filtry.zadanie.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@ToString
@Entity
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(length = 30, nullable = false)
    String username;
    @Column(length = 30, nullable = false)
    String password;

}
