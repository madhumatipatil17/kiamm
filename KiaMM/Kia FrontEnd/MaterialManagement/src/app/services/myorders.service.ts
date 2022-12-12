import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";
import { Ordersummary } from '../myorders/ordersummary';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class MyordersService {

  constructor(public http: HttpClient) {
  }

  public findAllPendingOrders(): Ordersummary[] {
    // @ts-ignore
    return this.http.get(environment.apiURL + "/MmProdReqHeaderEntity/mmprrprocess");
  }

  public findAllReciivedOrders(): Ordersummary[] {
    // @ts-ignore
    return this.http.get(environment.apiURL + "/MmProdReqHeaderEntity/mmprrecived");
  }

  public findAllRejectedOrders(): Ordersummary[] {
    // @ts-ignore
    return this.http.get(environment.apiURL + "/MmProdReqHeaderEntity/mmprrrejected");
  }
}
