import {Component, OnInit, TemplateRef} from '@angular/core';
import {Status, User} from "../../models/userModel";
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
import {ComplaintService} from "../../services/complaint.service";
import {Complaint, Reason} from "../../models/complaintModel";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  private userViewModel: UserViewModel;
  private user: User;
  private currentUser: User;
  private isSubbed: boolean;
  private modalRef: BsModalRef;
  private newReason: Reason;
  public newText: string;
  public reason: string = "Reason";
  constructor(private userService: UserService,
              private postService: PostService,
              private subService : SubService,
              private complaintService: ComplaintService,
              private modalService: BsModalService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router,
              private userViewModelService: UserViewModelService) {

  }
  bond: Sub;
  isComplaintExists: boolean;

  private subscriptions: Subscription[] =[];

  ngOnInit() {
    this.userService.checkGuest(this.router);
    const id = this.activateRoute.snapshot.params['id'];
    this.loadYourPageInfo(id);
    this.loadUserInfo(id);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.checkSubscribe(id);
    this.checkComplaint(id);
  };


  public isActive() : boolean {
    return this.userViewModel.status.toString() == "ACTIVE";
  }

  public isAdmin(): boolean {
    return this.currentUser.role.toString() == "ADMIN";
  }

  public checkSubscribe(id: number) : void {
    this.subService.isBondExists(id, this.currentUser.idUser).subscribe(answer => {
      this.isSubbed = answer as boolean;
    });
  }

  private blockUser(): void {
    this.subscriptions.push(this.userService.blockUser(this.user).subscribe(account => {
      this.user = account as User;
      this.loadYourPageInfo(this.user.idUser);
    }))
  }

  private unblockUser(): void {
    this.subscriptions.push(this.userService.unblockUser(this.user).subscribe(account => {
      this.user = account as User;
      this.loadYourPageInfo(this.user.idUser);
    }))
  }


  public checkComplaint(id: number) : void {
    this.subscriptions.push(this.complaintService.isComplaintExists(this.currentUser.idUser, id).subscribe(answer => {
      this.isComplaintExists = answer as boolean;
    }))
  }

  private loadUserInfo(id:number) {
    this.subscriptions.push(this.userService.getUserById(id).subscribe(model => {
      this.user = model as User;
    }))
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

  private cancelComplaint() : void {
    this.subscriptions.push(this.complaintService.deleteComplaint(this.currentUser.idUser, this.userViewModel.idUser).subscribe( value => {
      this.checkComplaint(this.userViewModel.idUser);
    }))
  }

  private sendComplaint(): void {
    this.subscriptions.push(this.complaintService.saveComplaint(new Complaint(this.newReason, this.newText, new Date(), this.userViewModel.idUser, this.currentUser.idUser)).subscribe( complaint =>{
      this.checkComplaint(this.userViewModel.idUser);
      this.closeModal();
    }))
  }

  private openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  private closeModal(): void {
    this.newText = "";
    this.reason = "Reason";
    this.modalRef.hide();
  }
}
