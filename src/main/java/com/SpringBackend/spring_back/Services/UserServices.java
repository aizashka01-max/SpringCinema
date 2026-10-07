package com.SpringBackend.spring_back.Services;

import com.SpringBackend.spring_back.DTO.RegisterRequest;
import com.SpringBackend.spring_back.Model.Users;
import com.SpringBackend.spring_back.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service //помечаем бин как сервис
public class UserServices {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //опишу в доке
    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Users UserRegister(RegisterRequest req)
    {
        if(!req.getPassword().equals(req.getConfirmPassword()))
        {
            throw new IllegalArgumentException("Пароли не совпадают");
        }
//        System.out.println("username=" + req.getUsername());
//        System.out.println("password=" + req.getPassword());
//        System.out.println("confirmPassword=" + req.getConfirmPassword());
        if(userRepository.existsByUsername(req.getUsername())){
            throw new IllegalStateException("Пользователь уже существует");
        }

        //создаем сущность которую hibernate положит в таблицу
        Users users = new Users();
        users.setUsername(req.getUsername());
        users.setPassword(passwordEncoder.encode(req.getPassword()));//хэширование пароля
        return userRepository.save(users);//сохраняем

    }
}
