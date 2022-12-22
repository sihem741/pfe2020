import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "./models/product";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  url = "http://localhost:8080/rest/product"

  constructor(private http: HttpClient) {
  }

  addProduct(product: Product): Observable<any> {
    return this.http.post(this.url, product);
  }

  getAll(): Observable<any> {
    return this.http.get(this.url)
  }

  getDefected(): Observable<any> {
    return this.http.get(this.url + '/defected')
  }

  editProduct(product: Product): Observable<any> {
    return this.http.put(this.url, product);
  }

  getLastAdded() {
    return this.http.get(this.url + '/lastAdded')

  }

  deleteProduct(row: Product):Observable<any> {
    console.log(row)
    return this.http.delete(this.url+"/"+row.id+"/"+row.matricule )

  }
}
