package outh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import outh.demo.model.UserApplication;
import outh.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository applicationUserRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApplication applicationUserApplication = applicationUserRepository.findByUsername(username);
        if (applicationUserApplication == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUserApplication.getUsername(), applicationUserApplication.getPassword(), applicationUserApplication.getAuthorities());
    }
}