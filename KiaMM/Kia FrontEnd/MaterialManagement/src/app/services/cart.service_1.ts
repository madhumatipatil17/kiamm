import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }
  api_url: string = "http://localhost:8080";

  getAllProducts(): Observable<any> {
    return this.http.get(environment.apiURL + "/v1/productMaster/getAllProducts", { responseType: 'json' });
  }
  
  public getProductsByNameOrPartnumber(prod_name : string, part_nbr : string, is_active: string){
    return this.http.get(environment.apiURL+"/v1/productMaster/products/byPartNo-or-byProductName-withFlag?prod_name=" + prod_name + "&part_nbr=" + part_nbr + "&is_active=" + is_active);
  }

  public getProductsByNameAndCategory(prod_name : string, category: string){
    return this.http.get(environment.apiURL+"/v1/productMaster/search-products-with-category?prod_name=" + prod_name + "&category=" + category);
  }

  public getDatawithKeyword(keyword: string) : Observable<any>{
    return this.http.get<any>(environment.apiURL+"/v1/productMaster/join_data/"+keyword);
  }
}
