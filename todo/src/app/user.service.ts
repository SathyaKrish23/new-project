import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Task } from './task';
import { Person } from './person';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  tempUser : string ='';
  tempId :number | undefined;

  setName(data:string,dataId:number){
    this.tempUser = data ; 
    this.tempId = dataId;
  }
  getName(){
    return this.tempUser;
  }
  getId(){
    return this.tempId;
  }

  constructor(private http:HttpClient){ }


  public loginUserFromRemote(user:Person):Observable<any>{
    console.log(user);
    return this.http.post<Person>("http://localhost:6655/login",user);
  }
  public  restore():Observable<Task[]>{
    return this.http.get<Task[]>("http://localhost:6655/"+this.tempId+"/todos");
  }

  public RegisterUserFromRemote(user:Person):Observable<any>{
    console.log(user);
    return this.http.post<any>("http://localhost:6655/register",user)
  }

  public ToDoListUserFromRemote(work:Task):Observable<any>{
    return this.http.post<any>("http://localhost:6655/"+this.tempId+"/todos",work)
  }
  public deleteTodo(wid : number):Observable<any>{
    return this.http.delete<any>("http://localhost:6655/"+this.tempId+"/todos/"+wid)
  }
  public deleteUser():Observable<any>{
    return this.http.delete<any>("http://localhost:6655/"+this.tempId+"/todos")
  }

}
