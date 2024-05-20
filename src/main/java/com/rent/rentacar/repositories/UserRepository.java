package com.rent.rentacar.repositories;

import com.rent.rentacar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
