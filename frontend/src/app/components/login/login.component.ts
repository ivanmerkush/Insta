import {Component, OnInit} from '@angular/core';
import {Role, Status, User} from "../../models/userModel";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

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
  public isCollapsedLog: boolean = true;
  public isCollapsedReg: boolean = true;
  public isCollapsedBan: boolean = true;
  public isSigned: boolean;
  constructor(private router: Router,
              private userService: UserService,
              private toggleService: BrowserAnimationsModule) { }


  ngOnInit() {
    let currentUser = JSON.parse(localStorage.getItem("currentUser"));
    if(currentUser) {
      this.router.navigate(['/home'], {});
    }
  }

  public loginToAccount(): void {
    this.isCollapsedLog = true;
    this.isCollapsedReg = true;
    this.isCollapsedBan = true;
    this.subscriptions.push(this.userService.getUserByNicknameAndPassword(this.logNickname, this.logPassword).subscribe( account => {
      this.logUser = account as User;
      if(this.logUser == null) {
        this.isCollapsedLog = false;
      }
      else {
        if(this.logUser.status.toString() == "BANNED")
        {
          this.isCollapsedBan = false;
        }
        else{
          localStorage.setItem("currentUser", JSON.stringify(this.logUser));
          this.router.navigate(['/home'], {});
        }
      }
    }))
  }

  public saveUserAccount(): void {
    this.isCollapsedLog = true;
    this.isCollapsedReg = true;
    this.subscriptions.push(this.userService.getUserByNickname(this.newNickname).subscribe(response => {
      if(response == null) {
        this.isCollapsedReg = false;
        this.isSigned = true;
        this.user = new User(this.newNickname,this.newName,this.newPassword,this.newEmail,"",
          Role.CUSTOMER, Status.ACTIVE,"defaultProfilePhoto.jpg");
        this.subscriptions.push(this.userService.saveUser(this.user).subscribe());
      }
      else {
        this.isCollapsedReg = false;
        this.isSigned = false;
      }
    }))
  }

}

