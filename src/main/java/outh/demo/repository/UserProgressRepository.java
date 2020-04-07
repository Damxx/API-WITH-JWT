package outh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import outh.demo.model.UserApplication;
import outh.demo.model.UserProgress;

@Repository
public interface UserProgressRepository  extends JpaRepository<UserProgress, Long> {

    UserProgress getUserProgressByUserApplication(UserApplication userApplication);


}
