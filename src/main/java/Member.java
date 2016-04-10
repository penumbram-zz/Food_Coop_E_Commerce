package main.java;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tolgacaner on 06/04/16.
 */
public class Member extends AbstractTimestampEntity {

    public Member(String fname, String lname, String password) {
        this.firstName = fname;
        this.lastName = lname;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "address_line_1",nullable = false)
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "birth_date",nullable = false)
    private Date birthDate;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "phone_number",nullable = false)
    private Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
