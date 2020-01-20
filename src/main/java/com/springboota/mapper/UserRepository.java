package com.springboota.mapper;

import com.springboota.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author {曹炳全}
 * @Title UserRepository
 * @Description
 * @date 2020/1/20 11:04
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}
