package com.project.facefake.repositories;

import com.project.facefake.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserById(String empId);

}
