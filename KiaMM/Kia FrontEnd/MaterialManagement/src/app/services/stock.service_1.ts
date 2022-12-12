import {HttpClient} from "@angular/common/http";
import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class StockService {
  itemsCategoryUrl = "http://localhost:8080/v1/entitydata/getallproductCategory";
  itemNameUrl = "http://localhost:8080/v1/productMaster/getBypartnumber/";
  partNumberUrl = "http://localhost:8080/v1/productMaster/getbycatogeryid/";

  constructor(private http: HttpClient) {
  }

  getAddedStock(): Observable<any> {
    return this.http.get(environment.apiURL + "/v1/productInventory/addedstocklist", {responseType: 'json'});
  }

  public getitemsCategory() {
    return this.http.get<any>(`${this.itemsCategoryUrl}`)
  }

  public getItemNames(partnumber: any) {
    return this.http.get<any>(this.itemNameUrl + partnumber, {responseType: 'json'})
  }

  public getPartNumbers(catogeryid: any) {
    return this.http.get<any>(this.partNumberUrl + catogeryid, {responseType: 'json'})
  }

  addStock(stockObj: any): Observable<any> {
    return this.http.post(environment.apiURL + "/v1/productInventory/addInventory", stockObj, {responseType: 'json'});
  }

  public findallProductdetailsbyProductname(productname: any) {
    return this.http.get<any>(
      "http://localhost:8080/v1/productInventory/stocklist/" + productname, {responseType: 'json'}
    )
  }

  public findallspecificationOfProduct(productname: any) {
    return this.http.get<any>(
      "http://localhost:8080/v1/productInventory/specifications/" + productname, {responseType: 'json'}
    )
  }

  public findHistoryOfProduct(productname: any) {
    return this.http.get<any>(
      "http://localhost:8080/v1/productInventory/history/" + productname, {responseType: 'json'}
    )
  }
}
