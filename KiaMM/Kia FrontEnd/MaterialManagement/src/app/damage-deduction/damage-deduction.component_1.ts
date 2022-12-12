import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Message, MessageService } from 'primeng/api';
import { DamageService } from '../services/damage.service';
import { ProductRequestService } from '../services/product-request.service';

@Component({
  selector: 'app-damage-deduction',
  templateUrl: './damage-deduction.component.html',
  styleUrls: ['./damage-deduction.component.css'],
  providers: [MessageService]
})
export class DamageDeductionComponent implements OnInit {
  categories: any;
  types: any;
  volumes: any;
  first = 0;
  rows = 10;
  selectedCategory: any;
  selectedType: any;
  selectedVolume: any;
  isReturnable: any;
  value: any;
  displayBasic: boolean = false;
  checked: boolean = false;
  damagedStocks: any;
  searchedStocks: any;
  history: any;
  model: any = {};
  // @ts-ignore
  msgs1: Message[];
  constructor(
    private damageService: DamageService,
    private productService: ProductRequestService,
    private messageService: MessageService
    // private router: Router
  ) {


  }

  ngOnInit(): void {
    this.getCategory();
    this.getTypes();
    this.getUOM();
    this.getHistory();
    this.model={
      "inventoryType":"D",
			"createdBy":1
    }
    // this.damageService.getAllDamagedStocks().then(data => (this.damagedStocks = data));
    // this.damageService.getAllSearchedStocks().then(data => (this.searchedStocks = data));
  }
  next() {
    this.first = this.first + this.rows;
  }

  prev() {
    this.first = this.first - this.rows;
  }
  isLastPage(): boolean {
    return this.damagedStocks ? this.first === (this.damagedStocks.length - this.rows) : true;
  }

  isFirstPage(): boolean {
    return this.damagedStocks ? this.first === 0 : true;
  }
  updateDamagedStocks(stock: any) {
    this.model.prodMasterId=stock.prodMasterId;
    this.model.Quantity=stock.totQty;
    console.log('update clicked');
    this.displayBasic = true;
  }
  checkRadioButton() {
    this.model.isReturnable=this.isReturnable;
  }

  getCategory() {
    this.productService.getCategory().subscribe((data: any) => {
      this.categories = data.datasource;
    })
  }
  getTypes() {
    this.productService.getType().subscribe((data: any) => {
      this.types = data.datasource;
    })

  }
  getUOM() {
    this.productService.getVolume().subscribe((data: any) => {
      this.volumes = data.datasource;
    })
  }

  onChangeCategory() {
    console.log(JSON.stringify(this.selectedCategory))
    this.model.prodCategoryId = this.selectedCategory.entityDataId;
  }

  onChangeType() {
    console.log(JSON.stringify(this.selectedType))
    this.model.prodTypeId = this.selectedType.entityDataId;
  }

  onChangeVolumn() {
    console.log(JSON.stringify(this.selectedVolume))
    this.model.uom = this.selectedVolume.entityDataId;
  }

  getSearchedStock() {
    this.damageService.getSearchedProduct(this.model.prodCategoryId, this.model.prodTypeId, this.model.prodNameOrNum).subscribe((data: any) => {
      this.searchedStocks = data;
    })
  }

  getHistory() {
    this.damageService.getHistory().subscribe((data: any) => {
      this.history = data;
    })
  }

  addDamagedStock() {
    this.damageService.addDamagedStock(this.model).subscribe((data: { message: any; }) => {
      
      this.displayBasic = false;
       this.messageService.add({ severity: 'success', summary: 'Success', detail: data.message });
    },
    (error : { error: any; })=>{
      console.log(error);
      this.messageService.add({ severity: 'error', summary: 'Error', detail: error.error.message });
    })
  }

}
