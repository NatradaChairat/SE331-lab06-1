package camt.cbsd.lab05.service;

import camt.cbsd.lab05.dao.StudentDao;
import camt.cbsd.lab05.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("secondLocal")
//@ConfigurationProperties(prefix="server")
@Service
public class StudentSecondServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    public List<Student> getStudents(){
        return studentDao.getStudents();
    }

    @Override
    public Student findById(long id) {
        return studentDao.findById(id);
    }
}
