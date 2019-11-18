
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


  constructor(id: number, nickname: string, name: string,password: string, email: string,  bio: string, role: Role,
              status: Status, subscribers: number, subscriptions: number, profilePhoto: string) {
    this.idUser = id;
    this.nickname = nickname;
    this.name = name;
    this.password = password;
    this.email = email;
    this.info = bio;
    this.role = role;
    this.status = status;
    this.subscribers = subscribers;
    this.subscriptions = subscriptions;
    this.profilePhoto = profilePhoto;
  }

  static cloneBase(user: User): User {
    // @ts-ignore
    const clonedUser: User = new User();
    clonedUser.idUser = user.idUser;
    clonedUser.nickname = user.nickname;
    clonedUser.name = user.name;
    clonedUser.password = user.password;
    clonedUser.email = user.email;
    clonedUser.info = user.info;
    clonedUser.subscribers = user.subscribers;
    clonedUser.subscriptions = user.subscriptions;
    clonedUser.profilePhoto = user.profilePhoto;
    return clonedUser;
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
