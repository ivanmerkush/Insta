export class Sub {
  idSub: number;
  idSubcriber: number;
  idHost: number;


  constructor(idSubcriber: number, idHost: number) {
    this.idSubcriber = idSubcriber;
    this.idHost = idHost;
  }
}
