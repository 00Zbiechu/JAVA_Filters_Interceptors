package pl.kursy.filtry.zadanie.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kursy.filtry.zadanie.model.UserEntity;
import pl.kursy.filtry.zadanie.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
