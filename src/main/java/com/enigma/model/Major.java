package com.enigma.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "major")
@NamedQueries({
        @NamedQuery(name = "find all major", query = "select m from Major m"),
        @NamedQuery(name = "find by id major", query = "select m from Major m where m.majorId = :id"),
        @NamedQuery(name = "find by name major", query = "select m from Major m where m.name_major = : name_major")
})
public class Major {
    @Id
    @SequenceGenerator(name="webuser_idwebuser_seq",
            sequenceName="webuser_idwebuser_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="webuser_idwebuser_seq")
    @Column(name = "major_id")
    private int majorId;

    @Column(name = "name_major", nullable = false, unique = true, length = 20)
    private String name_major;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    public Major() {
    }

    public Major(int majorId) {
        this.majorId = majorId;
    }

    public Major(String name_major) {
        this.name_major = name_major;
    }

    public Major(int majorId, String name_major) {
        this.majorId = majorId;
        this.name_major = name_major;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getName_major() {
        return name_major;
    }

    public void setName_major(String name_major) {
        this.name_major = name_major;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", name_major='" + name_major + '\'' +
                '}';
    }
}
