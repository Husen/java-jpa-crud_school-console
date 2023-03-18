package com.enigma;

import com.enigma.config.Factory;
//import com.enigma.model.Major;
import com.enigma.model.Club;
import com.enigma.model.Major;
import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repo.ClubRepo;
import com.enigma.repo.MajorRepo;
import com.enigma.repo.StudentRepo;
import com.enigma.service.ClubService;
import com.enigma.service.MajorService;
import com.enigma.service.StudentService;
import com.enigma.utils.Gender;
import com.enigma.utils.GenerateDate;
import jakarta.persistence.EntityManager;

public class App {
    static EntityManager entityManager = Factory.start();

    static StudentRepo studentRepo = new StudentRepo(entityManager);
    static StudentService studentService = new StudentService(studentRepo);

    static MajorRepo majorRepo = new MajorRepo(entityManager);
    static MajorService majorService = new MajorService(majorRepo);

    static ClubRepo clubRepo = new ClubRepo(entityManager);
    static ClubService clubService = new ClubService(clubRepo);

    public static void main(String[] args) {

        // standar code

        // create student
//        Student student = new Student(
//                "saidina",
//                "Husen",
//                Gender.MALE,
//                GenerateDate.generate("2000-10-08"),
//                "cianjur",
//                "0895619438831"
//        );
//        studentService.insert(student);

        // find all
         studentService.getAll(1,5).forEach(System.out::println);

        // find by id
//        Student student = new Student();
//        student.setStudentId(1);
//        Student student1 = studentService.getById(student.getStudentId());
//        System.out.println(student1);

        // like by firstname
//        studentService.getByName("dina");

        // update
//        Student student = new Student(
//                2,
//                "zenal",
//                "arifin",
//                Gender.MALE,
//                GenerateDate.generate("1999-10-01"),
//                "nagrak",
//                "08999999"
//        );
//        studentService.update(student);

        // delete
//        studentService.delete(1);


        // one to one code
        // create
//        Student student = new Student(
//                "saidina",
//                "Husen",
//                Gender.MALE,
//                GenerateDate.generate("2000-10-08"),
//                "cianjur",
//                "0895619438831",
//                new UserCredential("husen@gmail.com", "husen")
//        );
//        studentService.insert(student);

        // find all major
//        majorService.getAll(1,2);

        // find by id
//        majorService.getById(4);

        // update
//        Student student = new Student(
//                4,
//                "zenal",
//                "arifin",
//                Gender.MALE,
//                GenerateDate.generate("1999-10-01"),
//                "nagrak",
//                "08999999",
//                new UserCredential("baruu@gmail.com", "apaiyah")
//        );
//        studentService.update(student);

        // one to many code

        // create
//        Student student = new Student(
//                "selvi",
//                "nirmala",
//                Gender.FEMALE,
//                GenerateDate.generate("2000-10-21"),
//                "ngawi",
//                "0895619438832",
//                new UserCredential("selvi@gmail.com", "selvi"),
//                new Major(1)
//        );
//        studentService.insert(student);

        // update
//        Student student = new Student(
//                1,
//                "husen",
//                "saidina",
//                Gender.MALE,
//                GenerateDate.generate("2000-10-08"),
//                "cianjur",
//                "0895619438831",
//                new UserCredential("husen@gmail.com", "husen"),
//                new Major(2)
//        );
//        studentService.update(student);

        // create major
//        Major major = new Major("fisika");
//        majorService.insert(major);

        // get by id major
//        majorService.getById(1);

        // update major
//        Major major = new Major(2, "teknik informatika");
//        majorService.update(major);

        // delete major
//        majorService.delete(2);


        // one to many code

        // create
//        UserCredential userCredential = new UserCredential();
//        userCredential.setEmail("messi@gmail.com");
//        userCredential.setPassword("messi");
//
//        Student student = new Student();
//        student.setFirstName("Lionel");
//        student.setLastName("Messi");
//        student.setGender(Gender.MALE);
//        student.setBirthDate(GenerateDate.generate("1996-06-21"));
//        student.setAddress("argentina");
//        studentService.insert(student);

//        Club club = new Club();
//        club.setClubName("PSG");
//        clubService.insert(club);


    }
}
