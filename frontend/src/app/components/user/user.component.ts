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
import {UserViewModelService} from "../../services/userViewModel.service";
import {UserViewModel} from "../../models/userViewModel";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public userViewModel: UserViewModel;
  public currentUser: User;
  public isSubbed: boolean;
  constructor(private userService: UserService,
              private postService: PostService,
              private subService : SubService,
              private modalService: BsModalService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router,
              private userViewModelService: UserViewModelService) {

  }

  bond: Sub;

  private subscriptions: Subscription[] =[];

  ngOnInit() {
    this.loadingService.show();
    this.userService.checkGuest(this.router);
    const id = this.activateRoute.snapshot.params['id'];
    this.loadYourPageInfo(id);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.checkSubscribe(id);
  };

  public checkSubscribe(id: number) : void {
    this.subService.isBondExists(id, this.currentUser.idUser).subscribe(answer => {
      this.isSubbed = answer as boolean;
    });
  }

  private loadYourPageInfo(id: number) {
    this.subscriptions.push(this.userViewModelService.getUserViewModel(id).subscribe(model => {
      if(model == null) {
        this.router.navigate(['/**'],{});
      }
      this.userViewModel = model as UserViewModel;
    }))
  }

  private subscribe(): void {
    let bond = new Sub(this.currentUser.idUser, this.userViewModel.idUser);
    this.subscriptions.push(this.subService.addSub(bond).subscribe( smthg=>{
      this.subscriptions.push(this.subService.countSubscribers(this.userViewModel.idUser).subscribe(subs => {
        this.userViewModel.subscribers = subs as number;
      }))
      this.isSubbed = true;
    }))
  }

  private unsubscribe(): void {
    this.subscriptions.push(this.subService.getSub(this.userViewModel.idUser, this.currentUser.idUser).subscribe(sub => {
      this.bond = sub as Sub;
      this.subscriptions.push(this.subService.deleteSub(this.bond.idSub).subscribe(smthg => {
        this.subscriptions.push(this.subService.countSubscribers(this.userViewModel.idUser).subscribe(subs => {
          this.userViewModel.subscribers = subs as number;
        }))
      }))
      this.isSubbed = false;
    }));
    }


  ngOnDestroy() {
    this.subscriptions.forEach(subscripiton => subscripiton.unsubscribe());
  }
}
