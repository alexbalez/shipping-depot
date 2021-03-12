/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Profile Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Profile extends BaseEntity{

    public Profile(){}

    public Profile(String city, String country, String postalCode, String shippingAddress, String billingAddress, String shippingAddressDefault, String billingAddressDefault, LocalDate dateCreated, User userForeignKey) {
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.shippingAddressDefault = shippingAddressDefault;
        this.billingAddressDefault = billingAddressDefault;
        this.dateCreated = dateCreated;
        this.userForeignKey = userForeignKey;
    }

    public User getUserForeignKey() {
        return userForeignKey;
    }

    public void setUserForeignKey(User userForeignKey) {
        this.userForeignKey = userForeignKey;
    }

    public String getCity() {
        return city;
    }

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

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddressDefault() {
        return shippingAddressDefault;
    }

    public void setShippingAddressDefault(String shippingAddressDefault) {
        this.shippingAddressDefault = shippingAddressDefault;
    }

    public String getBillingAddressDefault() {
        return billingAddressDefault;
    }

    public void setBillingAddressDefault(String billingAddressDefault) {
        this.billingAddressDefault = billingAddressDefault;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = true)
    private String dob;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String country;

    @Column(nullable = true)
    private String postalCode;

    @Column(nullable = true)
    private String shippingAddress;

    @Column(nullable = true)
    private String billingAddress;

    @Column(nullable = true)
    private String shippingAddressDefault;

    @Column(nullable = true)
    private String billingAddressDefault;

    @Column(nullable = true)
    private LocalDate dateCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User userForeignKey;


}
