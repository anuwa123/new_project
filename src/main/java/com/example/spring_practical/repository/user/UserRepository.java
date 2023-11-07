package com.example.spring_practical.repository.user;

import com.example.spring_practical.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);

    List<User> findByStatus(User.Status active);
}
