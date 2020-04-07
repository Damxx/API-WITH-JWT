package outh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import outh.demo.model.UserApplication;
import outh.demo.model.UserProgress;
import outh.demo.repository.UserProgressRepository;

@Service
public class UserProgressService {

    private UserProgressRepository userProgressRepository;

    @Autowired
    public UserProgressService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public void addExperience(UserApplication userApplication, int experience) {
        UserProgress currentUserProgress = userProgressRepository.getUserProgressByUserApplication(userApplication);
        int newExp = currentUserProgress.getCurrent_xp() + experience;
        currentUserProgress.setCurrent_xp(newExp);

        updateLevelIfnecessary(currentUserProgress);

        userProgressRepository.save(currentUserProgress);

    }

    void updateLevelIfnecessary(UserProgress userProgress) {
        // Tu zaimplementowac mechanizm odpowiedzialny za update lvl
        userProgress.setCurrent_lvl(userProgress.getCurrent_lvl() + 1);
    }
}