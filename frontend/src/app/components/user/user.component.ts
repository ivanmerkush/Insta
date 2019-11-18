import {Component, OnInit, TemplateRef} from '@angular/core';
import {Role, Status, User} from "../../Models/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public user:User;
  public modalRef: BsModalRef;
  constructor(private userService: UserService,
              private modalService: BsModalService,
              private activateRoute: ActivatedRoute,
              private loadingService: Ng4LoadingSpinnerService) {

  }


  private subscriptions: Subscription[] =[];

  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadUserInfo(id);

  };

  private _refreshUser(): void {

  }


  public _openModal(template: TemplateRef<any>, user: User): void {

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
    this.updateInfo(user);
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
    }));
  }



  ngOnDestroy() {
    this.subscriptions.forEach(subscripiton => subscripiton.unsubscribe());
  }
}

