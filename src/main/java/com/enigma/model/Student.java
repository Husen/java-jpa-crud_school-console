package com.enigma.model;

import com.enigma.utils.Gender;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "find all student", query = "select s from Student s"),
        @NamedQuery(name = "find by id student", query = "select s from Student s where s.studentId = :id"),
        @NamedQuery(name = "find by firstName student", query = "select s from Student s where s.firstName = : firstName")
})
public class Student {
    @Id
    @SequenceGenerator(name="webuser_idwebuser_seq",
            sequenceName="webuser_idwebuser_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="webuser_idwebuser_seq")
    @Column(name = "student_id", updatable=false)
    private int studentId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "address", nullable = false, length = 225)
    private String address;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "credential_email")
    private UserCredential userCredential;

    @ManyToOne()
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "student_club",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<Club> clubs = new ArrayList<>();

    public Student() {
    }

    // create standar code
    public Student(String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // update standar code
    public Student(int studentId, String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // create with user credential
    public Student(String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
    }

    // update with user credential
    public Student(int studentId, String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
    }
//
//    // create with major
    public Student(String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
        this.major = major;
    }
    // update with major
    public Student(int studentId, String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential, Major major) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
        this.major = major;
    }

    // create with club
    public Student(String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential, Major major, List<Club> clubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
        this.major = major;
        this.clubs = clubs;
    }

    // update with club
    public Student(int studentId, String firstName, String lastName, Gender gender, Date birthDate, String address, String phoneNumber, UserCredential userCredential, Major major, List<Club> clubs) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userCredential = userCredential;
        this.major = major;
        this.clubs = clubs;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserCredential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userCredential=" + userCredential +
                '}';
    }
}
