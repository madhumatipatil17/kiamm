import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CartService} from '../services/cart.service';
import {ProductRequestService} from '../services/product-request.service';

interface City {
  name: string,
}

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  categories: any//Cotegory;
  products: any;
  selectedLine: any;
  selectedAccessories: any;
  selectedProduct = [];
  checked: boolean = false;
  prodMasterIdArr = [];
  lines = [];
  prod_name: string = "";
  searchText: string = "";
  part_nbr: string = "";
  is_active: string = "Y";
  selectedCategory: string = "";
  keyword: string = "";

  constructor(
    private cartService: CartService,
    private productService: ProductRequestService,
    private router: Router) {

  }
  


  public findproducts(data: any) {
    this.prod_name = data.value;
    this.part_nbr = data.value;
    let resp = this.cartService.getProductsByNameOrPartnumber(this.prod_name, this.part_nbr, this.is_active);
    resp.subscribe((data: any) => {
      this.products = data.content;
      console.log(data.content);
    });
  }

  public dataWithKeyword(data: any) {
    console.log(data);
    if (data.value != null && data.value.name != null) {
      this.selectedCategory = data.value.name;
    } else {
      this.selectedCategory = "";
    }

    this.searchText = "";
    this.cartService.getDatawithKeyword(this.selectedCategory).subscribe((data: any) => {
      //console.log(data);
      this.products = data;
    })

  }

  public findProductsWithCategory(data: any) {
    this.prod_name = data.value;
    this.part_nbr = data.value;

    // Case 1: No category is selected, search all products
    if (this.selectedCategory == "") {
      this.findproducts(data);
      return;
    }

    // Case 2: A category is selected, search product with this category
    let resp = this.cartService.getProductsByNameAndCategory(this.prod_name, this.selectedCategory);
    resp.subscribe((data: any) => {
      this.products = data;
      console.log(data);
    });
  }

  ngOnInit(): void {
    this.productService.getCategory().subscribe((data: any) => {
      this.categories = data.datasource
      console.log(JSON.stringify(this.categories))
    })
    
    this.productService.getLine().subscribe((data: any) => {
      this.lines = data.datasource
      console.log(JSON.stringify(this.lines))
    })
    this.cartService.getAllProducts().subscribe((data: any) => {
      console.log(data)
      console.log(data.datasource.content)
      this.products = data.datasource
      console.log(JSON.stringify(this.lines))
    })
    
     
    
  }
  

  checkBoxValue(id: any) {
    this.prodMasterIdArr = id;
    console.log(this.prodMasterIdArr)
  }

  addTocart() {
    // this.router.navigateByUrl('/place-order',{state:this.prodMasterIdArr})
    this.router.navigate(["/place-order", {'idArr': this.prodMasterIdArr}]);
  }
}
