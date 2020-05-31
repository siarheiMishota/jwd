package by.mishota.graduation.entity;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private final int id;
    private int passportId;
    private LocalDate birth;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private String fatherName;
    private Gender gender;
    private boolean confirmed;

    private User(int id, int passportId, LocalDate birth, String login, String password, String firstName, String surname, String fatherName, Gender gender, boolean confirmed) {
        this.id = id;
        this.passportId = passportId;
        this.birth = birth;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.fatherName = fatherName;
        this.gender = gender;
        this.confirmed = confirmed;
    }

    public static User create(int id, int passportId, LocalDate birth, String login, String password, String firstName, String surname, String fatherName, Gender gender, boolean confirmed){
        return new User(id,  passportId, birth, login,  password, firstName,  surname, fatherName, gender, confirmed);
    }

    public int getId() {
        return id;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                passportId == user.passportId &&
                confirmed == user.confirmed &&
                Objects.equals(birth, user.birth) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(fatherName, user.fatherName) &&
                gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passportId, birth, login, password, firstName, surname, fatherName, gender, confirmed);
    }

    @Override
    public String toString() {
        return "User{ " + id + ", " + passportId + ", " + birth + ", " + login +", " + password +", " + firstName +
                ", " + surname +", " + fatherName +", " + gender +", " + confirmed;
    }
}
