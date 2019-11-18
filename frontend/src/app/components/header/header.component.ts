import {Component, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {User} from "../../Models/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public searchQuery: string;
  public mamks: string[];
  public goodmamks: string[] = [];
  public users: User[];
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService) { }

  ngOnInit() {
    this.mamks = ["123", "456", "qwe", "asd", "asdf", "1"];
  }

  public findEqual() : void {
    this.mamks.forEach(mamka => {
      if(mamka.includes(this.searchQuery)) {
        this.goodmamks.push(mamka);
      }
    })
  }

  public openModal(template: TemplateRef<any>) : void {
    this.goodmamks = [];
    this.findEqual();
    this.modalRef = this.modalService.show(template);

  }

  public closeModal(): void {
    this.modalRef.hide();
  }
}
