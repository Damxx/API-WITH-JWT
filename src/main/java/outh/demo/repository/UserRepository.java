package outh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import outh.demo.model.UserApplication;

@Repository
public interface UserRepository extends JpaRepository<UserApplication, Long> {

    UserApplication findByUsername(String userName);

    boolean existsByUsernameOrEmail(String username,String name);

}
