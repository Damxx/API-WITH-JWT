package outh.demo.model;

import javax.persistence.*;

@Entity
public class UserProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long progres_id;
    private int current_lvl;
    private int current_xp;

    @JoinColumn(name = "userApplication", referencedColumnName = "user_id")
    @OneToOne
    private UserApplication userApplication;

    public UserProgress() {
    }

    public long getProgres_id() {
        return progres_id;
    }

    public void setProgres_id(long progres_id) {
        this.progres_id = progres_id;
    }

    public int getCurrent_lvl() {
        return current_lvl;
    }

    public void setCurrent_lvl(int current_lvl) {
        this.current_lvl = current_lvl;
    }

    public int getCurrent_xp() {
        return current_xp;
    }

    public void setCurrent_xp(int current_xp) {
        this.current_xp = current_xp;
    }

    public UserApplication getUserApplication() {
        return userApplication;
    }

    public void setUserApplication(UserApplication userApplication) {
        this.userApplication = userApplication;
    }
}
