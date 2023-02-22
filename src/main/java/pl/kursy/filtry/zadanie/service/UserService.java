package pl.kursy.filtry.zadanie.service;

import pl.kursy.filtry.zadanie.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUser();

}
