export class Items {
  catogery?: string

  productname?: string

  partnumber?: string

  reciveddate?: Date
  purchaseorderno?: number

  purchaseorderqty?: number

  invoiceno?: number

  invoiceqty?: number

  entiytype?: string

  lentgh?: string

  dia?: string

  drivesize?: string

  quantity?: string


  constructor(catogery: string, productname: string, partnumber: string, reciveddate: Date, purchaseorderno: number, purchaseorderqty: number, invoiceno: number, invoiceqty: number, entiytype: string, lentgh: string, dia: string, drivesize: string, quantity: string) {
    this.catogery = catogery;
    this.productname = productname;
    this.partnumber = partnumber;
    this.reciveddate = reciveddate;
    this.purchaseorderno = purchaseorderno;
    this.purchaseorderqty = purchaseorderqty;
    this.invoiceno = invoiceno;
    this.invoiceqty = invoiceqty;
    this.entiytype = entiytype;
    this.lentgh = lentgh;
    this.dia = dia;
    this.drivesize = drivesize;
    this.quantity = quantity;
  }
}
