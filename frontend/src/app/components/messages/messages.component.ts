import { Component, OnInit } from '@angular/core';
import {User} from "../../Models/userModel";
import {Message} from "../../Models/messageModel";
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor() { }


  users: User[] = [];
  messages: Message[] = [];

  ngOnInit() {
  }

}
