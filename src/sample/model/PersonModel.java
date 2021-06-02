package sample.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false ,nullable = false)
    private Integer id;
    @Column (name = "first_name",nullable = false)
    private String firstname;
    @Column (name = "last_name",nullable = false)
    private String lastname;
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column (name = "gender",nullable = false)
    private String gender;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfFirstname() {
        return firstname;
    }

    public void setfFirstname(String fName) {
        this.firstname = fName;
    }

    public String getlLastname() {
        return lastname;
    }

    public void setlLastname(String lName) {
        this.lastname = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
