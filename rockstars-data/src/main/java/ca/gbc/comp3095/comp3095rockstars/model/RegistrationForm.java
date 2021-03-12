/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Registration form class that helps create the form values to be generated for the user model>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotBlank(message = "First name cannot be empty.")
    @Pattern(regexp="^[a-zA-Z]*$", message = "should contain only alphabets")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp="^[a-zA-Z]*$", message = "should contain only alphabets")
    private String lastName;

    private String address;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "You must enter a valid email address.")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min=6, max=12, message = "Password must be 6-12 characters in length.")
    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[#?!@$%^&*-])$", message = "Password must contain at least 1" +
            "uppercase letter and 1 special character.")
    private String password;

    @NotBlank(message = "You must confirm your password.")
    private String passwordConfirm;

    private String role;

    //no arg constructor
    public RegistrationForm(){
        super();
    }

    public RegistrationForm(String firstName, String lastName, String address, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = "USER";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
