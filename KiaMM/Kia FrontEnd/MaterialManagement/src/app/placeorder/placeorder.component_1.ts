import { Component, OnInit } from '@angular/core';
import { Orders } from './orders';
import { MaterialService } from '../services/material.service';
import { ActivatedRoute } from '@angular/router';
import { Message, MessageService } from 'primeng/api';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css'],
  providers: [MessageService]
})
export class PlaceorderComponent implements OnInit {

  orders: Orders[] | any;
  model: any = {};
  prodIdArr: any = [];
  displayModal: boolean | any;
  message: string = "";
  constructor(
    private orderservice: MaterialService,
    public activatedRoute: ActivatedRoute,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      let idArr = params['idArr'];
      if (idArr != undefined && idArr != []) {
        var prodId = idArr.split(',');
        for (var i = 0; i < prodId.length; i++)
          this.prodIdArr.push(+ prodId[i]);
      }
    });
    this.getOrders();
    this.model = {
      "mmProdReqHeaderEntity": {
        "reqDept": 1,
        "reqSection": 1,
        "reqLine": 1,
        "requestedBy": 1,
        "orderType": "xyz",
        "prcsStatusId": 1,
        "sicComments": "comments",
        "aicComments": "aiccomment",
        "createdBy": 1,
      },
      "mmProdReqDetailsEntity": []
    }
  }
  showModalDialog() {
    this.displayModal = true;
  }

  private getOrders() {
    this.orderservice.getOrderSummary(this.prodIdArr).subscribe((items) => {
      this.orders = items.datasource;
      console.log(this.orders)
    });
  }

  placeOrder() {
    if (!this.orders || this.orders.length < 1) {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: "No Products Selected" });
      return;
    }
    else {
      for (let i = 0; i < this.orders.length; ++i) {
        if (this.orders[i].orderedQty === '' || this.orders[i].orderedQty === undefined) {
          this.messageService.add({ severity: 'error', summary: 'Error', detail: "Quantity Is Mandatory" });
          return;
        }
      }
     
      console.log(this.model)
      this.model.mmProdReqDetailsEntity = this.orders;
      this.orderservice.placeOrder(this.model).subscribe(data => {
        console.log(data);
        if (data.status == true) {
          this.message = data.message + " With Order Request Number " + data.datasource.reqNbr;
          this.showModalDialog();
          // this.messageService.add({ severity: 'success', summary: 'Success', detail: data.message });
          this.orders = [];
        }
        else {
          this.messageService.add({ severity: 'error', summary: 'Error', detail: "Unable to place order" });
        }
      }, err => {
        console.log(err);
        if(err.error.datasource!=null&& err.error.datasource.message!=null){
          this.message = err.error.datasource.message;
        }
        else if(err.error.message!=null){
          this.message = err.error.message;
        }
        else{
          this.message = "";
        }
        this.messageService.add({ severity: 'error', summary: 'Error', detail: "Unable to place order " + this.message });
      });
    }
  }


  deleteOrder(id: any) {
    for (let i = 0; i < this.orders.length; ++i) {
      if (this.orders[i].prodMasterId === id) {
        this.orders.splice(i, 1);
      }
    }
  }

  showViaService(msg: any) {
    this.messageService.add({ severity: 'success', summary: 'success', detail: msg });
  }

}
