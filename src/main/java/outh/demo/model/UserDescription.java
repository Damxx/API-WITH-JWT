package outh.demo.model;

import javax.persistence.*;

@Entity
public class UserDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customNameForUser;
    private int userPrefeneceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userApplication", referencedColumnName = "user_id")
    private UserApplication userApplication;

    public UserDescription() {
    }

    public UserDescription(String customNameForUser) {
        this.customNameForUser = customNameForUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomNameForUser() {
        return customNameForUser;
    }

    public void setCustomNameForUser(String customNameForUser) {
        this.customNameForUser = customNameForUser;
    }

    public int getUserPrefeneceId() {
        return userPrefeneceId;
    }

    public void setUserPrefeneceId(int userPrefeneceId) {
        this.userPrefeneceId = userPrefeneceId;
    }

    public UserApplication getUserApplication() {
        return userApplication;
    }

    public void setUserApplication(UserApplication userApplication) {
        this.userApplication = userApplication;
    }
}
