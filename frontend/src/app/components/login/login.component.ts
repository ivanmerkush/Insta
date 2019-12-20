import {Component, OnInit} from '@angular/core';
import {Role, Status, User} from "../../models/userModel";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User;
  public subscriptions: Subscription[] = [];
  public logNickname: string;
  public logPassword: string;
  public newNickname: string;
  public newName: string;
  public newEmail: string;
  public newPassword: string;
  public logUser: User;
  constructor(private router: Router,
              private userService: UserService) { }


  ngOnInit() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if(currentUser) {
      this.router.navigate(['/home'], {});
    }
  }

  public loginToAccount(): void {
    this.subscriptions.push(this.userService.getUserByNickname(this.logNickname).subscribe( account => {
      this.logUser = account as User;
      localStorage.setItem("currentUser", JSON.stringify(this.logUser));
      this.router.navigate(['/home'], {});
      this.logUser = null;
      }))
  }

  public addUserAccount(): void {
    this.user = new User(this.newNickname,this.newName,this.newPassword,this.newEmail,"",
      Role.CUSTOMER, Status.ACTIVE,"D:/Photo/defaultProfilePhoto.jpg");
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe());
  }

}

