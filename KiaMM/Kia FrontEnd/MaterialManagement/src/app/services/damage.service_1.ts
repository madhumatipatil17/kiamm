import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DamageService {

  constructor(private http: HttpClient) { }

  getAllOrders() {
    return this.http.get<any>('assets/orders.json')
      .toPromise()
      .then(res => res.data)
      .then(data => { return data; });
  }

  getOrderDetails() {
    return this.http.get<any>('assets/order-details.json')
      .toPromise()
      .then(res => res.data)
      .then(data => { return data; });
  }
  getNewProductDetails() {
    return this.http.get<any>('assets/product-details.json')
      .toPromise()
      .then(res => res.data)
      .then(data => { return data; });
  }
  getAllStocks() {
    return this.http.get<any>('assets/stock-details.json')
      .toPromise()
      .then(res => res.data)
      .then(data => { return data; });
  }
  getAllDeepSocketDetails() {
    return this.http.get<any>('assets/stock-details.json')
      .toPromise()
      .then(res => res.data)
      .then(data => { return data; });
  }
  getAllDamagedStocks() {
    return this.http.get<any>('assets/damaged-stocks.json')
    .toPromise()
    .then(res => res.data)
    .then(data => { return data; });
  }
  getAllSearchedStocks() {
    return this.http.get<any>('assets/searched-stocks.json')
    .toPromise()
    .then(res => res.data)
    .then(data => { return data; });
  }

  public getSearchedProduct(categoryId : number, productTypeId : number, prodNameOrNum: string){
    return this.http.get(environment.apiURL+"/v1/productInventory/searchInventory?categoryId="+ categoryId +"&&productTypeId="+ productTypeId +"&&prodNameOrNum="+ prodNameOrNum +"");
  }

  public getHistory(){
    return this.http.get(environment.apiURL+"/v1/productInventory/damagedInventoryHistory");
  }

  addDamagedStock(stockObj: any): Observable<any> {
    return this.http.post(environment.apiURL + "/v1/productInventory/addInventory", stockObj, {responseType: 'json'});
  }
}
