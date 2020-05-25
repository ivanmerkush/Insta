import {Role, Status} from "./userModel";

export class UserViewModel {
  idUser: number;
  nickname: string;
  name: string;
  email: string;
  info: string;
  status: Status;
  role: Role;
  profilePhoto: string;
  numberOfPosts: number;
  subscribers: number;
  subscriptions: number;


  constructor(idUser: number, nickname: string, name: string, email: string, info: string, status: Status,
              role: Role, profilePhoto: string, numberOfPosts: number, subscribers: number, subscriptions: number) {
    this.idUser = idUser;
    this.nickname = nickname;
    this.name = name;
    this.email = email;
    this.info = info;
    this.status = status;
    this.role = role;
    this.profilePhoto = profilePhoto;
    this.numberOfPosts = numberOfPosts;
    this.subscribers = subscribers;
    this.subscriptions = subscriptions;
  }
}
