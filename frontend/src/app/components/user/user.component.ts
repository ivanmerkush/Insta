import {Component, OnInit, TemplateRef} from '@angular/core';
import {Role, Status, User} from "../../models/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "../../services/post.service";
import {SubService} from "../../services/sub.service";
import {Sub} from "../../models/subModel";

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
  public isSubbed: boolean;
  constructor(private userService: UserService,
              private postService: PostService,
              private subService : SubService,
              private modalService: BsModalService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router) {

  }

  bond: Sub;
  numberOfPosts: number;

  private subscriptions: Subscription[] =[];

  ngOnInit() {
    this.userService.checkGuest(this.router);
    const id = this.activateRoute.snapshot.params['id'];
    this.loadUserInfo(id);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.checkSubscribe(id);
  };

  public checkSubscribe(id: number) : void {
    this.subService.isBondExists(id, this.currentUser.idUser).subscribe(answer => {
      this.isSubbed = answer as boolean;
    });
  }

  private subscribe(): void {
    let bond = new Sub(this.currentUser.idUser, this.user.idUser);
    this.subscriptions.push(this.subService.addSub(bond).subscribe( smthg=>{
      this.subscriptions.push(this.subService.countSubscribers(this.user.idUser).subscribe(subs => {
        this.followers = subs as number;
      }))
      this.isSubbed = true;
    }))
  }

  private unsubscribe(): void {
    this.subscriptions.push(this.subService.getSub(this.user.idUser, this.currentUser.idUser).subscribe(sub => {
      this.bond = sub as Sub;
      this.subscriptions.push(this.subService.deleteSub(this.bond.idSub).subscribe(smthg => {
        this.subscriptions.push(this.subService.countSubscribers(this.user.idUser).subscribe(subs => {
          this.followers = subs as number;
        }))
      }))
      this.isSubbed = false;
    }));
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
