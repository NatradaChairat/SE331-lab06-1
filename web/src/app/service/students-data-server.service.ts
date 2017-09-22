import {Injectable} from '@angular/core';
import {Student} from '../students/student';
import {Http} from '@angular/http';
import {StudentsDataService} from './students-data.service';

@Injectable()
export class StudentsDataServerService {
  constructor(private http: Http) {

  }

  getStudentsData() {
    let studentArray: Student[];
    return this.http.get('http://localhost:8080/student')
      .map(res => res.json());
  }

  getStudent(id: number) {
    let student: Student;
    return this.http.get('http://localhost:8080/student/'+id)
      //.map(res => res.json());
      .map((res:Response) => {
        if(res){
          if(res.status ===200){
            return res.json();
          }
          if(res.status ===204){
            return null;
          }
        }

      });
  }
}
