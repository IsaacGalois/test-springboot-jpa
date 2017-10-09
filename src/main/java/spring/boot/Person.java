package spring.boot;

import org.hibernate.jpa.internal.schemagen.JpaSchemaGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Integer Id;

    @Version
    private Integer version;

    private String title;
    private String firstName;
    private String lastName;
    private String displayFirstName;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> emailList;


    public Person() {}

    public Person(String firstName) {
        this.firstName = firstName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDisplayFirstName() {
        return displayFirstName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.displayFirstName = displayFirstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }
}
