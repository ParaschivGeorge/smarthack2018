package com.losnarghileros.smarthack2018.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class MiniTestObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "test_object_id")
    private TestObject testObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public TestObject getTestObject() {
        return testObject;
    }

    public void setTestObject(TestObject testObject) {
        this.testObject = testObject;
    }
}
