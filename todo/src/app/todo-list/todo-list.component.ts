import { HttpClient } from '@angular/common/http';
import { Component, OnInit , Input} from '@angular/core';
import { Router , ActivatedRoute} from '@angular/router'; 
import { NgbTypeaheadWindow } from '@ng-bootstrap/ng-bootstrap/typeahead/typeahead-window';
import { findIndex, never } from 'rxjs';
import { Person } from '../person'
import { Task } from '../task';
import { UserService } from '../user.service';


@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit{

today:string;
real_name :string ='';
real_id :number | undefined;
real_task:string[]=[];

work = new Task();


addItem(newItem: string) {
  if(newItem == ''){ }
  else{
    this.real_task.push(newItem);
    this.service.ToDoListUserFromRemote(this.work).subscribe(
      data =>{
        console.log("Response occured")
        
      },
      error =>{
        console.log("bad input")
      }
    ) 
  }

}
restore(){
  this.service.restore().subscribe(
    data =>{
      for(let i=0; i<data.length;i++){
      const remains = data[i].title;
      if(remains != null){
        this.real_task.push(remains.trim())
        this.real_task.filter(function(elem,index,self){
          return index == self.indexOf(elem);
        })
        
      }
      
     }
      console.log("Getted all worked")
      
      
    },
    error =>{
      console.log("can't get")
    })
}



remove(i:number) {
 this.real_task.splice(i,1)
}

logout(){
  console.log("logging out")
  this.router.navigate(['/login']);
  }

deleteUser() {
  this.service.deleteUser().subscribe(
    data =>{
      console.log("account deleted")
      this.logout();
    },
    error => {
      console.log(" error : cant't do that")
    }
  )
}
  

  
  constructor(private service:UserService,private router:Router,private http:HttpClient,private route:ActivatedRoute){ 
    this.today = new Date().toLocaleDateString();
    this.real_name = this.service.getName()
    this.real_id  = this.service.getId();
  }
  ngOnInit(): void {
    
  }

}

  



