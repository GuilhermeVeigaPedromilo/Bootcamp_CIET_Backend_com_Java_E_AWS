package br.com.dio.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class UserModel {
    // Attreibutes
    private long id;
    private String name;
    private String email;
    private OffsetDateTime birthday;

    // Getters and Setters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public OffsetDateTime getBirthday() {
        return birthday;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    // Constructors - They are used to create instances or objects of the class
    public UserModel() {

    }

    public UserModel(long id, String name, String email, OffsetDateTime birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    // Overrides - They are used to improve the usability of the class
    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel userModel)) return false;
        return id == userModel.id &&
                Objects.equals(name, userModel.name) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(birthday, userModel.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday);
    }
}
