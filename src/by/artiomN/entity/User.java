package by.artiomN.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 4931296140759028997L;
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender=Gender.MALE;
    //private String role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Long id, String login, String password) {
        this.id = id;

        this.login = login;
        this.password = password;
    }

    public User(long id, String login) {

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
