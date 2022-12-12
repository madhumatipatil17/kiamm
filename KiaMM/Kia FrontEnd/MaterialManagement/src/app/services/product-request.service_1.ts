import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductRequestService {

  constructor(private http: HttpClient) {
  }

  createProduct(prodObj: any): Observable<any> {
    return this.http.post(environment.apiURL + "/v1/productMaster/addproduct", prodObj, {responseType: 'json'});
  }


  getCategory() {
    return this.http.get<any>(environment.apiURL + '/v1/entitydata/getallproductCategory', {responseType: 'json'})
  }

  getType() {
    return this.http.get<any>(environment.apiURL + '/v1/entitydata/getallproductType', {responseType: 'json'})
  }

  getVolume() {
    return this.http.get<any>(environment.apiURL + '/v1/entitydata/getvolumn', {responseType: 'json'})
  }

  getLine() {
    return this.http.get<any>(environment.apiURL + '/v1/entitydata/getline', {responseType: 'json'})
  }
}
