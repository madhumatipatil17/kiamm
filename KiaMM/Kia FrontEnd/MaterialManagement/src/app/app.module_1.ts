import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule, Routes} from '@angular/router';
import {ButtonModule} from 'primeng/button';
import {CalendarModule} from 'primeng/calendar';
import {CardModule} from 'primeng/card';
import {CarouselModule} from 'primeng/carousel';
import {CheckboxModule} from 'primeng/checkbox';
import {DialogModule} from 'primeng/dialog';
import {DropdownModule} from 'primeng/dropdown';
import {InputTextModule} from 'primeng/inputtext';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {MessageModule} from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {RadioButtonModule} from 'primeng/radiobutton';
import {StepsModule} from "primeng/steps";
import {TableModule} from 'primeng/table';
import {TabMenuModule} from 'primeng/tabmenu';
import {TabViewModule} from 'primeng/tabview';
import {TimelineModule} from "primeng/timeline";
import {ToastModule} from "primeng/toast";
import {AdditemsComponent} from './AddStock/additems/additems.component';
import {AddstockComponent} from './AddStock/addstock/addstock.component';
import {ProductstockdetailsComponent} from './AddStock/productstockdetails/productstockdetails.component';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {DamageDeductionComponent} from './damage-deduction/damage-deduction.component';
import {MyordersComponent} from './myorders/myorders.component';
import {ProcessingordersComponent} from './myorders/processingorders/processingorders.component';
import {RecivedordersComponent} from './myorders/recivedorders/recivedorders.component';
import {RejectedordersComponent} from './myorders/rejectedorders/rejectedorders.component';
import {PlaceorderComponent} from './placeorder/placeorder.component';
import {ProductRequestComponent} from './product-request/product-request.component';
import {RequesterdetailsComponent} from './Requesterdetails/requesterdetails/requesterdetails.component';
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import { SafeUrlPipe } from './pipe/safe-url.pipe';

const navigationPath: Routes = [
  {path: 'add-product', component: ProductRequestComponent},
  {path: 'cart', component: ShoppingCartComponent},
  {path: 'place-order', component: PlaceorderComponent},
  {path: "myorders", component: MyordersComponent, pathMatch: "full"},
  {path: "pendingorders", component: ProcessingordersComponent, pathMatch: "full"},
  {path: "recivedorders", component: RecivedordersComponent, pathMatch: "full"},
  {path: "rejectedorders", component: RejectedordersComponent, pathMatch: "full"},
  {path: "damage-deduction", component: DamageDeductionComponent, pathMatch: "full"},
  {path: '', redirectTo: 'add-product', pathMatch: 'full'},
  {path: 'req/:reqnbr', component: RequesterdetailsComponent},
  {path: 'stock/:prname', component: ProductstockdetailsComponent},
  {path: 'addstock', component: AddstockComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    ShoppingCartComponent,
    PlaceorderComponent,
    ProductRequestComponent,
    MyordersComponent,
    ProcessingordersComponent,
    RecivedordersComponent,
    RejectedordersComponent,
    RequesterdetailsComponent,
    DamageDeductionComponent,
    AddstockComponent,
    AdditemsComponent,
    ProductstockdetailsComponent,
    SafeUrlPipe,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    TableModule,
    HttpClientModule,
    DropdownModule,
    CheckboxModule,
    ButtonModule,
    RouterModule.forRoot(navigationPath),
    DialogModule,
    MessagesModule,
    MessageModule,
    BrowserAnimationsModule,
    CardModule,
    TabMenuModule,
    AppRoutingModule,
    StepsModule,
    InputTextModule,
    InputTextareaModule,
    ButtonModule,
    DropdownModule,
    BrowserAnimationsModule,
    CarouselModule,
    DialogModule,
    TabViewModule,
    CardModule,
    TimelineModule,
    CalendarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatFormFieldModule,
    ToastModule,
    RadioButtonModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
