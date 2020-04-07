package outh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import outh.demo.model.UserDescription;

@Repository
public interface UserDescriptionRepository extends JpaRepository<UserDescription, Long> {


}

