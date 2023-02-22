package pl.kursy.filtry.zadanie.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "USERDATA")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(length = 30, nullable = false)
    String username;
    @Column(length = 30, nullable = false)
    String password;

}
