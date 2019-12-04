export class Photo {
  idPhoto: number;
  photoPath: string;
  idPost: number;

  constructor(idPhoto: number, photoPath: string, idPost: number) {
    this.idPhoto = idPhoto;
    this.photoPath = photoPath;
    this.idPost = idPost;
  }
}
