package outh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import outh.demo.model.UserApplication;
import outh.demo.model.UserDescription;
import outh.demo.model.UserProgress;
import outh.demo.repository.UserRepository;

@Service
public class UserService {
    private UserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveUser(UserApplication userApplication){
        userApplication.setPassword(bCryptPasswordEncoder.encode(userApplication.getPassword()));
        userApplication.setRole("ROLE_USER");

        UserDescription userDescription = new UserDescription(userApplication.getUsername());
        userDescription.setUserApplication(userApplication);

        UserProgress userProgress = new UserProgress();
        userProgress.setUserApplication(userApplication);


        userApplication.setUserDescription(userDescription);
        userApplication.setUserProgress(userProgress);
        applicationUserRepository.save(userApplication);
    }


}
