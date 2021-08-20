import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg:any=''
  credentials={
    username:'',
    password:''
  }
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  

  onSubmit(){

    console.log("Form is submitted");
    if((this.credentials.username!='' && this.credentials.password!='') && (this.credentials.username!=null && this.credentials.password!=null)){
      console.log("We have to submit the form");
      this.loginService.generateToken(this.credentials).subscribe(
        (response:any) =>{
          console.log(response.jwtToken)
          this.loginService.loginUser(response.jwtToken);
          window.location.href="/dashboard"
        },
        error =>{
          console.log(error);
          this.msg="Enter Valid Credentials";
          console.log("Invalid Credentials");
        }
      )
    }
    else{
      if((this.credentials.username=="" && this.credentials.password=="")||(this.credentials.username!=null && this.credentials.password!=null)){
        alert("Fields cannot be empty");
        console.log("Fields are empty!!!");
      }else{
      alert("Enter the valid details");
      }
    }
  }
  

  

}
