/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <User Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.util.*;


@Entity
public class User extends BaseEntity{

    @Column(nullable = false, name="first_name")
    private String firstName;

    @Column(nullable = false, name="lastName")
    private String lastName;

    @Column(nullable = false, name="address")
    private String address;

    @Column(nullable = false, name="email")
    private String email;

    @Column(nullable = false, name="password")
    private String password;

    @Column
    private String roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<CreditProfile> creditProfiles = new HashSet<>();

    @Column
    private Date dateOfBirth;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postalCode;

    public String getCity() {
        return city;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Message> messages = new HashSet<>();

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userForeignKey")
    private Set<Profile> profiles = new HashSet<>();


    public User(String firstName, String lastName, String address, String email, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;

        if(roles == null){
            this.roles = "USER";
        }else{
            this.roles = roles;
        }
    }

    public User() {}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles() {
        this.roles = "USER";
    }

    public void setRolesAdmin() {
        this.roles = "ADMIN";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userForeignKey")
    public Set<Profile> profiles;

    public Set<Profile> getProfiles(){
        return profiles;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public Set<CreditProfile> getCreditProfiles() {
        return creditProfiles;
    }

    public void setCreditProfiles(Set<CreditProfile> creditProfiles) {
        this.creditProfiles = creditProfiles;
    }

}
