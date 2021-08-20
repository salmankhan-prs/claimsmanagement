import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Member } from '../Data/member';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  url="http://localhost:8020/member"

  constructor(private http:HttpClient) { }
  public claimSubmit(mem:any){
    return this.http.post(`${this.url}/submitClaim/`,mem);
  }

  
  
}
