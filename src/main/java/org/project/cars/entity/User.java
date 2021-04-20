package org.project.cars.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Invalid username")
    @Size(min = 3, max = 20, message = "Must not be shorter than 3 and longer than 20 characters")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Please fill in the form")
    @Size(min = 3, max = 60, message = "Must not be shorter than 3 characters")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Invalid name")
    @Size(min = 2, max = 20, message = "Must not be shorter than 2 and longer than 20 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Invalid name")
    @Size(min = 2, max = 20, message = "Must not be shorter than 2 and longer than 20 characters")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    @Column(name = "email")
    private String email;

    @Column(name = "money")
    private int money;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Info> info;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User(){}

    public User(int id, String username, String password, String firstName, String lastName, String gender, String email, int money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.money = money;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", money=" + money +
                '}';
    }

    public void addMoney(int money){
        this.money += money;
    }
}
