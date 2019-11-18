export class Photo {
  id: number;
  pathFile: string;
  postId: number;

  constructor(photoId: number, pathFile: string, postId: number) {
    this.id = photoId;
    this.pathFile = pathFile;
    this.postId = postId;
  }
}
