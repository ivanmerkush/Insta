import {Component, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {User} from "../../modules/userModel";
import {Hashtag} from "../../modules/hashtagModel";
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
              private activatedRoute: Router,
              private modalService: BsModalService) { }

  ngOnInit() {
      this.activatedRoute.events.subscribe(value => {console.log(value)});
  }

  public findEqual() : void {
    this.goodvars = [];
    this.users.forEach(user => {
      if(user.nickname.includes(this.searchQuery)) {
        this.goodvars.push(user);
      }
    })
  }

  public openModal(template: TemplateRef<any>) : void {
    this.loadSearchResults();
    if(this.goodvars)
    {
      this.notNull = true;
      this.findEqual();
      this.modalRef = this.modalService.show(template);
    }
    else
    {
      this.notNull = false;
    }
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public loadSearchResults() : void {
    this.subscriptions.push(this.userService.getUsersBySearch(this.searchQuery).subscribe(accounts => {
        this.users = accounts as User[];
    }))
  }
}
