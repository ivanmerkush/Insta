import {Component, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {User} from "../../models/userModel";
import {Hashtag} from "../../models/hashtagModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {HashtagService} from "../../services/hashtag.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public notNull: boolean = true;
  public searchQuery: string;
  public hashtags: Hashtag[];
  public users: User[];
  public modalRef: BsModalRef;
  public subscriptions: Subscription[] = [];
  public currentUser: User;
  public hidden : boolean;

  constructor(private userService: UserService,
              private hashtageService: HashtagService,
              private router: Router,
              private activateRoute: ActivatedRoute,
              private modalService: BsModalService) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentItem"));
    if(this.currentUser != null) {
      this.hidden = false;
    }
    this.router.events.subscribe();
  }

  public showHashtagResult(hashtag: Hashtag) : void {
    this.modalRef.hide();
    this.router.navigate(['/hashtag/id/' + hashtag.idHashtag]);
  }

  public showUserPage(user: User) : void {
    this.modalRef.hide();
    this.router.navigate(['/user/' + user.idUser], {});
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public loadSearchResults(template: TemplateRef<any>) : void {
    if (this.searchQuery.charAt(0) == '#') {
      this.loadHashtags(template);
    } else {
      this.loadUsers(template);
    }
  }

  private loadHashtags(template: TemplateRef<any>) : void {
    this.subscriptions.push(this.hashtageService.getHashtagsBySearch(this.searchQuery.substring(1)).subscribe(results => {
      this.hashtags = results as Hashtag[];
      if (this.hashtags.length != 0) {
        this.notNull = true;
      } else {
        this.notNull = false;
      }
      this.modalRef = this.modalService.show(template);
    }))
  }

  private loadUsers(template: TemplateRef<any>) : void {
      this.subscriptions.push(this.userService.getUsersBySearch(this.searchQuery).subscribe(accounts => {
        this.users = accounts as User[];
        if(this.users.length != 0) {
          this.notNull = true;
        }
        else {
          this.notNull = false;
        }
        this.modalRef = this.modalService.show(template);
      }))
  }
}
