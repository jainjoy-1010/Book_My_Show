package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {// user is model and long is datatype of  primary key of user table

    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);


}
