package com.example.spring_practical.services.user;

import com.example.spring_practical.dto.user.UserDto;
import com.example.spring_practical.models.user.User;
import com.example.spring_practical.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveuser(UserDto request){

        String encodepassword =passwordEncoder.encode(request.getPassword());

        User user = new User();

        UUID uuid =UUID.randomUUID();
        String str = uuid.toString();

        user.setId(str);
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(encodepassword);
        user.setStatus(User.Status.ACTIVE);

        User user_repo = userRepository.save(user);
        return user_repo;
    }

    public List<User> getAllUsers(){
//        return userRepository.findAll();
        return userRepository.findByStatus(User.Status.ACTIVE);
    }

    public User updateById(String id, UserDto request){
        User user = userRepository.findById(id).get();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

//    public void deleteUser(String id){
//        userRepository.deleteById(id);
//    }

    public User deleteUser(String id){
        User user = userRepository.findById(id).get();
        user.setStatus(User.Status.INACTIVE);

        return userRepository.save(user);
    }
    public User loginUser(String email,String password) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(email);

        if(user == null || !passwordEncoder.matches(password, user.getPassword())){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return user;
    }
}
