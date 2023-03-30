package vn.com.devmaster.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.services.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccount(String account);
}