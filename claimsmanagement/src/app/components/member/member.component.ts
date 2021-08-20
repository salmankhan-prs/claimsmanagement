import { Component, OnInit } from '@angular/core';
import { Member } from 'src/app/Data/member';
import { MemberService } from 'src/app/services/member.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {

  p:any='';
  msg:any='';
  mem=new Member();
  constructor(private service:MemberService) { }

  ngOnInit(): void {
  }
  onSubmit(){
    if((this.mem.claimId!=null&&this.mem.policyId!=null&&this.mem.memberId!=null&&
      this.mem.benefitId&&this.mem.providerId&&this.mem.amountClaimed&&this.mem.amountSettled)){
    

    console.log(this.mem);
    if(this.mem.claimId==null){
      alert('enter values');
      return;
    }
    this.service.claimSubmit(this.mem).subscribe(
      (data) => {
        this.p=data;
        console.log(data);
        this.msg="Success";
      },
      (error)=>{
        console.log(error);
      }
    )
    }
    else{
      alert("Please provide all the fields");
    }
  }
  

}
