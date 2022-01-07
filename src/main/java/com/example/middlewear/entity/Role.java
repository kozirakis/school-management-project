package com.example.middlewear.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Getter
@Setter
@Document(collection = "role")
public class Role {
    @Id
    private String id;
    private String name;
    @DBRef
    @JsonManagedReference
    private Collection<User> users;

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

}
