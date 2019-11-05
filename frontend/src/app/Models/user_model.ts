export class User{
  private _id: number;
  private _nickname:string;
  private _name: string;
  private _email:string;
  private _bio:string;
  private _subscribers:number;
  private _subscriptions:number;
  private _userPhoto:string;


  constructor(id: number, nickname: string, name: string, email: string,  bio: string, subscribers: number, subscriptions: number, userPhoto: string) {
    this._id = id;
    this._nickname = nickname;
    this._name = name;
    this._email = email;
    this._bio = bio;
    this._subscribers = subscribers;
    this._subscriptions = subscriptions;
    this._userPhoto = userPhoto;
  }

  static cloneBase(user: User): User {
    // @ts-ignore
    const clonedUser: User = new User();
    clonedUser._id = user._id;
    clonedUser._nickname = user._nickname;
    clonedUser._name = user._name;
    clonedUser._email = user._email;
    clonedUser._bio = user._bio;
    clonedUser._subscribers = user._subscribers;
    clonedUser._subscriptions = user._subscriptions;
    clonedUser._userPhoto = user._userPhoto;
    return clonedUser;
  }

  get nickname(): string {
    return this._nickname;
  }

  set nickname(value: string) {
    this._nickname = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get bio(): string {
    return this._bio;
  }

  set bio(value: string) {
    this._bio = value;
  }


  get subscribers(): number {
    return this._subscribers;
  }

  set subscribers(value: number) {
    this._subscribers = value;
  }

  get subscriptions(): number {
    return this._subscriptions;
  }

  set subscriptions(value: number) {
    this._subscriptions = value;
  }


  get userPhoto(): string {
    return this._userPhoto;
  }

  set userPhoto(value: string) {
    this._userPhoto = value;
  }

}

