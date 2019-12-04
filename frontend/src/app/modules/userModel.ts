export class User{
  idUser: number;
  nickname:string;
  name: string;
  password: string;
  email:string;
  info:string;
  role: Role;
  status: Status;
  subscribers:number;
  subscriptions:number;
  profilePhoto:string;


  constructor(nickname: string, name: string,password: string, email: string,  info: string, role: Role,
              status: Status, subscribers: number, subscriptions: number, profilePhoto: string) {
    this.nickname = nickname;
    this.name = name;
    this.password = password;
    this.email = email;
    this.info = info;
    this.role = role;
    this.status = status;
    this.subscribers = subscribers;
    this.subscriptions = subscriptions;
    this.profilePhoto = profilePhoto;
  }

}

export enum Role {
  ADMIN,
  CUSTOMER
}

export enum Status {
  ACTIVE,
  BANNED
}
