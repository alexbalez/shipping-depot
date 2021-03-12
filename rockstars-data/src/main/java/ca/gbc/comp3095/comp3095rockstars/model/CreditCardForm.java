package ca.gbc.comp3095.comp3095rockstars.model;

public class CreditCardForm {

    private String type;

    private String expiry;

    private String cardHolder;

    private Long cardNumber;

    private String defaultCreditCard;

    private User user;

    public CreditCardForm() {
        super();
    }

    public CreditCardForm(String type, String expiry, String cardHolder, Long cardNumber, String defaultCreditCard, User user) {
        this.type = type;
        this.expiry = expiry;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.defaultCreditCard = defaultCreditCard;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
