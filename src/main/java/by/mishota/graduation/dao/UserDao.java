package by.mishota.graduation.dao;

import by.mishota.graduation.entity.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll() ;
    Optional<User> findById(int id);
    List<User> findAllMoreBirth(LocalDate numberPoints);

}
