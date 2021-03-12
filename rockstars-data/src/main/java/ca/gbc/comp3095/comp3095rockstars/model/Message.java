/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Message Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Message extends BaseEntity{

    @Column(nullable = true, name="fromWho")
    private String fromWho;

    @Column(nullable = true, name="toWho")
    private String toWho;

    @Column(nullable = true, name="status")
    private String status;

    @Column(nullable = true, name="description")
    private String description;

    @Column(nullable = true, name="subject")
    private String messageSubject;

    @Column(nullable = true, name="date_created")
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Message(String fromWho, String toWho, String status, String description, String messageSubject, LocalDate dateCreated) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.status = status;
        this.description = description;
        this.messageSubject = messageSubject;
        this.dateCreated = dateCreated;
    }

    public Message() {
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
