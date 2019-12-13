export class Like{
  idLike: number;
  idUser: number;
  idPost: number;

  constructor(idUser: number, idPost: number) {
    this.idUser = idUser;
    this.idPost = idPost;
  }
}
