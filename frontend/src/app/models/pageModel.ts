import {PostViewModel} from "./postViewModel";

export class PageModel {
  totalElements: number;
  page: PostViewModel[];

  constructor(totalElements: number, page: PostViewModel[]) {
    this.totalElements = totalElements;
    this.page = page;
  }
}
