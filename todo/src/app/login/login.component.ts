import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Person } from '../person';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:Person;

  userName: string='';
  

  constructor(private service: UserService,private router : Router,private route:ActivatedRoute){ 
    this.user = new Person();  
   }

  ngOnInit(){
    
   }

  
  loginUser(){
    console.log(this.user)
    this.service.loginUserFromRemote(this.user).subscribe(data =>{
    console.log("login success")
    this.service.setName(data.name,data.id);
    return this.router.navigate(['/todo'])
     
    },
    error =>{
      alert("Sorry please enter correct username and password")
    });
    
  }

  register(){
    this.router.navigate(['/register']);
  }
   
  


  
  
  
}
