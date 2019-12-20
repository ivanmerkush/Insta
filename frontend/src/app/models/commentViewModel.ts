export class CommentViewModel {
  nickname: string;
  profilePhoto: string;
  comment: Comment;

  constructor(nickname: string, profilePhoto: string, comment: Comment) {
    this.nickname = nickname;
    this.profilePhoto = profilePhoto;
    this.comment = comment;
  }
}
