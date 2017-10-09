package spring.boot;

import javax.persistence.*;

@Entity
public class Email {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private Integer Id;

    @Version
    private Integer version;

    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Email() {}
    public Email(String emailAddress) {
        this.setEmailAddress(emailAddress);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
