package com.endava.pocu.carpark.repository;

import com.endava.pocu.carpark.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
