/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Credit Profile Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CreditProfile extends BaseEntity{

    @Column(nullable = false, name="type")
    private String type;

    @Column(nullable = false, name="expiry")
    private String expiry;

    @Column(nullable = false, name="card_holder")
    private String cardHolder;

    @Column(nullable = false, name="card_number")
    private Long cardNumber;

    @Column( name="default_credit_card")
    private String defaultCreditCard;

    @Column(nullable = false, name="date_card_created")
    private LocalDate dateCardCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CreditProfile() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public CreditProfile(String type, String expiry, String cardHolder, Long cardNumber, String defaultCreditCard, LocalDate dateCardCreated, User user) {
        this.type = type;
        this.expiry = expiry;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.defaultCreditCard = defaultCreditCard;
        this.dateCardCreated = dateCardCreated;
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDefaultCreditCard() {
        return defaultCreditCard;
    }

    public void setDefaultCreditCard(String defaultCreditCard) {

        this.defaultCreditCard = defaultCreditCard;
    }

    public LocalDate getDateCardCreated() {
        return dateCardCreated;
    }

    public void setDateCardCreated() {
        this.dateCardCreated = LocalDate.now();;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

