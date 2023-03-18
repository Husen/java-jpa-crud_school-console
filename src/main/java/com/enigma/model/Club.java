package com.enigma.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "club")
@NamedQueries({
        @NamedQuery(name = "find all club", query = "select c from Club c"),
        @NamedQuery(name = "find by id club", query = "select c from Club c where c.clubId = :id"),
        @NamedQuery(name = "find by name club", query = "select c from Club c where c.clubName = : clubName")
})
public class Club {
    @Id
    @SequenceGenerator(name="webuser_idwebuser_seq",
            sequenceName="webuser_idwebuser_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="webuser_idwebuser_seq")
    @Column(name = "club_id")
    private int clubId;

    @Column(name = "club_name", nullable = false, length = 50, unique = true)
    private String clubName;

    @ManyToMany(mappedBy = "clubs")
    private List<Student> students;

    public Club() {
    }

    public Club(int clubId) {
        this.clubId = clubId;
    }

    public Club(String clubName) {
        this.clubName = clubName;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId=" + clubId +
                ", clubName='" + clubName + '\'' +
                ", students=" + students +
                '}';
    }
}
