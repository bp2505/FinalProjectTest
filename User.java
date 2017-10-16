package FinalProject;

import java.io.File;

public class User extends Person {
    String username;
    String email;
    String phonenumber;
    String password;
    File profilePhoto;
    String propicpth;
    public User(){
        username = null;
        email = null;
        phonenumber = null;
        password = null;
        profilePhoto = null;
        propicpth = null;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    String gender;


    public String getPropicpth() {
        return propicpth;
    }

    public void setPropicpth(String propicpth) {
        this.propicpth = propicpth;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public File getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(File profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
