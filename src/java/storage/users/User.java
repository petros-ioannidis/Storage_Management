/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.users;

/**
 *
 * @author zbs
 */
public class User {

    private UserRole role;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Boolean full_user;

    /**
     * @return the id
     */
    public User(String Username, UserRole Role, String Password, String Name, String Surname, String Email, Boolean Full_user) {

        this.role = Role;
        this.username = Username;
        this.password = Password;
        this.name = Name;
        this.surname = Surname;
        this.email = Email;
        this.full_user = Full_user;
    }


    /**
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the Surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the full_user
     */
    public Boolean getFull_user() {
        return full_user;
    }

    /**
     * @param full_user the full_user to set
     */
    public void setFull_user(Boolean full_user) {
        this.full_user = full_user;
    }
}
