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
  constructor(private router: Router,
              private userService: UserService) { }


  ngOnInit() {

  }

  public loginToAccount(): void {
    localStorage.clear();
    this.subscriptions.push(this.userService.getUserByNickname(this.logNickname).subscribe( account => {
      let serialUser = JSON.stringify(account as User);
      localStorage.setItem("currentUser", serialUser);
      this.router.navigate(['/home'], {});
    }))
  }

  public addUserAccount(): void {
    this.user = new User(this.newNickname,this.newName,this.newPassword,this.newEmail,"",
      Role.CUSTOMER, Status.ACTIVE,"D:/Photo/defaultProfilePhoto.jpg");
    this.subscriptions.push(this.userService.addNewUser(this.user).subscribe());
  }
}

