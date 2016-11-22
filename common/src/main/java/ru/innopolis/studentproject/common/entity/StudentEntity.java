package ru.innopolis.studentproject.common.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by innopolis on 17.11.16.
 */
public class StudentEntity implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;

    public StudentEntity(){

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
