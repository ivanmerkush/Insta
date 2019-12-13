import {Component, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {User} from "../../models/userModel";
import {Hashtag} from "../../models/hashtagModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {forEach} from "@angular/router/src/utils/collection";
import {Subscription} from "rxjs";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public notNull: boolean = true;
  public searchQuery: string;
  public goodvars: User[] = [];
  public users: User[];
  public modalRef: BsModalRef;
  public subscriptions: Subscription[] = [];



  constructor(private userService :UserService,
              private router: Router,
              private modalService: BsModalService) { }

  ngOnInit() {
      this.router.events.subscribe();
  }

  public findEqual() : void {
    this.goodvars = [];
    this.users.forEach(user => {
      if(user.nickname.includes(this.searchQuery)) {
        this.goodvars.push(user);
      }
    })
  }

  public showUserPage(user: User) : void {
    this.modalRef.hide();
    this.router.navigate(['/user/' + user.idUser], {});
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public loadSearchResults(template: TemplateRef<any>) : void {
    this.subscriptions.push(this.userService.getUsersBySearch(this.searchQuery).subscribe(accounts => {
        this.users = accounts as User[];
        if(this.users)
        {
          this.notNull = true;
          this.findEqual();
          this.modalRef = this.modalService.show(template);
        }
        else
        {
          this.notNull = false;
        }
      }))
  }
}
