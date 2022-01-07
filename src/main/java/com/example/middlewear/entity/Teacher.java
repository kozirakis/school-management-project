package com.example.middlewear.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "teachers")
public class Teacher {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String comment;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String address, String phoneNumber, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }


    @Override
    public String toString() {
        return String.format(
                "Teacher[id=%s, firstName='%s', lastName='%s', adress='%s', phoneNumber='%d', comment='%s' ]",
                id, firstName, lastName, address, phoneNumber);
    }
}
