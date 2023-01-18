import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../person';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

user = new Person();


  constructor(private service:UserService,private router:Router){}
registerUser() {
  this.service.RegisterUserFromRemote(this.user).subscribe(
    data =>{
      console.log("Response occured")
      this.router.navigate(['/login']);
    },
    error =>{
      console.log("bad input")
    })
}

}
