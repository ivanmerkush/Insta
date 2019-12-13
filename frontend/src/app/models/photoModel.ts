export class Photo {
  idPhoto: number;
  photoPath: string;
  idPost: number;

  constructor(photoPath: string, idPost: number) {
    this.photoPath = photoPath;
    this.idPost = idPost;
  }
}
