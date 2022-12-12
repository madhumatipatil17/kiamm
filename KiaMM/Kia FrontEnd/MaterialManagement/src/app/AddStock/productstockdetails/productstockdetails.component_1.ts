import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {StockService} from 'src/app/services/stock.service';

@Component({
  selector: 'app-productstockdetails',
  templateUrl: './productstockdetails.component.html',
  styleUrls: ['./productstockdetails.component.css']
})
export class ProductstockdetailsComponent implements OnInit {
  // @ts-ignore
  productname: string;
  // @ts-ignore
  items: any;

  public specifications: any;
  public history: any;


  constructor(private route: ActivatedRoute, public stockService: StockService) {
  }

  ngOnInit(): void {


    this.route.paramMap.subscribe((params: ParamMap) => {
      // @ts-ignore
      let productname = params.get('prname');
      // @ts-ignore
      this.productname = productname;


    });


    this.getallProductDetails(this.productname)
    this.getAllProductSpecifications(this.productname)
    this.getHistoryofProduct(this.productname)
  }


  public getallProductDetails(productname: string) {
    this.stockService.findallProductdetailsbyProductname(productname).subscribe(response => {

      // @ts-ignore
      this.items = response.datasource;
      // console.log(this.items)
    })


  }

  public getAllProductSpecifications(productname: any) {
    this.stockService.findallspecificationOfProduct(productname).subscribe(data => {
      this.specifications = data.datasource;
      console.log("Specifications" + data.datasource)
    })

  }

  public getHistoryofProduct(productname: any) {
    this.stockService.findHistoryOfProduct(productname).subscribe(data => {
      this.history = data.datasource;
      console.log("History" + data.datasource)
    })

  }

}
