import { Component, OnInit } from '@angular/core';
import { ProductRequestService } from '../services/product-request.service';
import { HttpClient, HttpEventType } from '@angular/common/http';
import { Message, MessageService } from 'primeng/api';

interface Cotegory {
  name: string,
  id: number
  // status : boolean
  // message : string
  // data : [{}]
}

interface Types {
  name: string,
}

interface Volume {
  name: string,
  id: number
}


@Component({
  selector: 'app-product-request',
  templateUrl: './product-request.component.html',
  styleUrls: ['./product-request.component.css'],
  providers: [MessageService]
})
export class ProductRequestComponent implements OnInit {
  categories: any//Cotegory;
  types: any //Types[];
  volumes: any//Volume[];
  selectedCategory: any;
  selectedType: any;
  selectedVolume: any;
  selectedFile: File | any;
  // @ts-ignore
  msgs1: Message[];
  model: any = {};


  constructor(
    private productService: ProductRequestService,
    private messageService: MessageService) {
    this.productService.getCategory().subscribe((data: any) => {
      this.categories = data.datasource
      console.log(JSON.stringify(this.categories))
    })

    this.productService.getType().subscribe((data: any) => {
      this.types = data.datasource
      console.log(JSON.stringify(this.types))
    })

    this.productService.getVolume().subscribe((data: any) => {
      this.volumes = data.datasource
      console.log(JSON.stringify(this.volumes))
    })
  }

  ngOnInit(): void {
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
    console.log(this.selectedFile.name);

  }


  onChangeCategory() {
    console.log(JSON.stringify(this.selectedCategory))
    this.model.prodCategoryId = this.selectedCategory.entityDataId
    console.log(this.model.prodCategoryId)
  }

  onChangeType() {
    console.log(JSON.stringify(this.selectedType))
    this.model.prodTypeId = this.selectedType.entityDataId
    console.log(this.model.prodTypeId)
  }

  onChangeVolumn() {
    console.log(JSON.stringify(this.selectedVolume))
    this.model.uom = this.selectedVolume.entityDataId
    console.log(this.model.uom)
  }

  onSubmit() {
    console.log(this.selectedFile);
    const uploadData = new FormData;
    uploadData.append('imgFile', this.selectedFile, this.selectedFile.name);

    for (let key in this.model) {
      let value = this.model[key];
      console.log(key, value);
      if (key !== 'imgFile') {
        uploadData.append(key, value);
      }
    }
    // console.log("imgFile"+uploadData.get("imgFile"));
    // console.log("prodCategoryId"+uploadData.get("prodCategoryId"));
    // console.log("prodTypeId"+uploadData.get("prodTypeId"));
    // console.log("prodCode"+uploadData.get("prodCode"));
    // console.log("prodName"+uploadData.get("prodName"));
    // console.log("partNumber"+uploadData.get("partNumber"));
    // console.log("description"+uploadData.get("description"));
    // console.log("lenght"+uploadData.get("lenght"));
    // console.log("diaMM"+uploadData.get("diaMM"));
    // console.log("driveSize"+uploadData.get("driveSize"));
    // console.log("uom"+uploadData.get("uom"));
    // console.log("minQty"+uploadData.get("minQty"));
    // console.log("maxQty"+uploadData.get("maxQty"));
    // console.log("totalQty"+uploadData.get("totalQty"));
    // console.log("createdBy"+uploadData.get("createdBy"));
    // console.log(this.productRequest)

    this.productService.createProduct(uploadData).subscribe((data: { message: any; }) => {
      console.log(data);
      this.messageService.add({ severity: 'success', summary: 'Success', detail: data.message });
    },
    (error : { error: any; })=>{
      console.log(error);
      this.messageService.add({ severity: 'error', summary: 'Error', detail: error.error.message });
    })
  }
}
