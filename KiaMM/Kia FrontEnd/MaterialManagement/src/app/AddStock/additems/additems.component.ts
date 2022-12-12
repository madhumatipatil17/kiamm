import {Component, OnInit} from '@angular/core';

import {ProductRequestService} from "../../services/product-request.service";
import {StockService} from "../../services/stock.service";
import {Items} from "../items";

@Component({
  selector: 'app-additems',
  templateUrl: './additems.component.html',
  styleUrls: ['./additems.component.css']
})
export class AdditemsComponent implements OnInit {


  itemsCategory: any;
  itemNames: any;
  partNumbers: any;
  items: Items[] | any;
  model: any = {};
  selectedCategory: any;
  selectedPartnumber: any;
  selectedProductname: any;

  constructor(private stockservice: StockService, private productService: ProductRequestService) {

  }


  ngOnInit(): void {
    this.getCategories()

    this.model = {
      "inventoryType": "A",
      "createdBy": 1
    }

  }

  saveItems() {

    console.log(this.model);
    this.stockservice.addStock(this.model).subscribe(response => {
      console.log(response)
    })

  }

  addStock() {
    this.stockservice.addStock(this.model).subscribe((data: { message: any; }) => {
        console.log(data)
        // this.messageService.add({severity: 'success', summary: 'Success', detail: data.message});
      },
      (error: { error: any; }) => {
        console.log(error);
        // this.messageService.add({severity: 'error', summary: 'Error', detail: error.error.message});
      })
  }


  onChangeProductname() {
    let productname = this.selectedProductname.productname;
    productname.trim();
    this.model.productname = productname
    this.model.prodMasterId = this.selectedProductname.productmasterid;
    console.log(productname.trim()
    )

  }

  onChangePartnumber() {
    this.model.partnumber = this.selectedPartnumber.partnumber
    console.log(this.model.partnumber)
    this.getItemNames(this.model.partnumber)

  }

  onChangeCategory() {
    console.log(this.selectedCategory.code)
    this.model.prodCategoryId = this.selectedCategory.entityDataId
    console.log(this.model.prodCategoryId)
    this.getPartNumbers(this.model.prodCategoryId)
  }

  private getCategories() {
    this.productService.getCategory().subscribe(response => {
      console.log(response)
      this.itemsCategory = response.datasource;
      console.log(this.itemsCategory)
    })
  }

  private getItemNames(partnumber: any) {
    this.stockservice.getItemNames(partnumber).subscribe(response => {
      this.itemNames = response.datasource;

    })
  }

  private getPartNumbers(catogeryid: any) {
    this.stockservice.getPartNumbers(catogeryid).subscribe(response => {
      // console.log(response.datasource)
      this.partNumbers = response.datasource;

    })
  }

}
