import {Component, OnInit, TemplateRef} from '@angular/core';
import {Role, Status, User} from "../../modules/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../../services/post.service";
import {SubService} from "../../services/sub.service";
import {Sub} from "../../modules/subModel";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public user:User;
  public currentUser: User;
  public followers: number;
  public follows: number;
  public modalRef: BsModalRef;
  constructor(private userService: UserService,
              private postService: PostService,
              private subService : SubService,
              private modalService: BsModalService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService) {

  }

  numberOfPosts: number;

  private subscriptions: Subscription[] =[];

  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadUserInfo(id);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  };

  private _refreshUser(): void {

  }

  private subscribe(): void {
    let bond = new Sub(this.currentUser.idUser, this.user.idUser);
    this.subscriptions.push(this.subService.addSub(bond).subscribe( smthg=>{
      this.subscriptions.push(this.subService.countSubscribers(this.user.idUser).subscribe(subs => {
        this.followers = subs as number;
      }))
    }))
  }

  public _openModal(template: TemplateRef<any>): void {

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
    this.updateInfo(this.user);
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public updateInfo(user: User) : void {
    this.userService.updateUserInfo(user);
  }

  private loadUserInfo(id: number): void {

    this.loadingService.show();
    this.subscriptions.push(this.userService.getUserById(id).subscribe(account => {
      this.user = account as User;
      this.subscriptions.push(this.postService.countPosts(this.user.idUser).subscribe(publishes => {
        this.numberOfPosts = publishes as number;
      }));
      this.subscriptions.push(this.subService.countSubscribers(this.user.idUser).subscribe(subs => {
        this.followers = subs as number;
      }))
      this.subscriptions.push(this.subService.countSubscriptions(this.user.idUser).subscribe(sups => {
        this.follows = sups as number;
      }))
    }));
  }



  ngOnDestroy() {
    this.subscriptions.forEach(subscripiton => subscripiton.unsubscribe());
  }
}
