package camt.cbsd.lab05.dao;

import camt.cbsd.lab05.entity.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Profile("secondLocal")
@ConfigurationProperties(prefix = "server")
@Repository
public class MyStudentDaoImpl extends AbstractStudentDao{
    /*List<Student> students;
    String imageBaseUrl;
    String baseUrl;
    String imageUrl;
    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }*/
    @PostConstruct
    private void init(){
        this.imageBaseUrl = this.baseUrl + this.imageUrl;
        students = new ArrayList<>();
        Student student = new Student(1,"SE-999","Miffy","Bunny",
                3.15,imageBaseUrl+"miffy.png",true,0,
                "The most beloved one");
        students.add(student);
        student = new Student(2,"SE-998","Bruno","Mars",
                3.59,imageBaseUrl+"bruno.jpg",false,15,
                "The great man ever!!!!");
        students.add(student);
    }

    /*@Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student findById(long id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }*/
}
