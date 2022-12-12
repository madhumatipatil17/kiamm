export class Stockorders {
  public itemname: string;
  public catogery: string;
  public partnumber: string;
  public purchaseordernumber: string;
  public purchaseorderquantity: string;
  public invoicenumber: string;

  public invoicequantity: string;
  public reciveddate: string;
  public status: string;


  constructor(itemname: string, catogery: string, partnumber: string, purchaseordernumber: string, purchaseorderquantity: string, invoicenumber: string, invoicequantity: string, reciveddate: string, status: string) {
    this.itemname = itemname;
    this.catogery = catogery;
    this.partnumber = partnumber;
    this.purchaseordernumber = purchaseordernumber;
    this.purchaseorderquantity = purchaseorderquantity;
    this.invoicenumber = invoicenumber;
    this.invoicequantity = invoicequantity;
    this.reciveddate = reciveddate;
    this.status = status;
  }
}
