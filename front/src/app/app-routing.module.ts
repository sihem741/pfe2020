import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddProductComponent} from "./add-product/add-product.component";
import {ShowHistoryComponent} from "./show-history/show-history.component";
import {ErrorValidationComponent} from "./error-validation/error-validation.component";
import {LastAddedComponent} from "./last-added/last-added.component";


const routes: Routes = [
  {path: 'addProduct', component: AddProductComponent},
  {path: 'showHistory', component: ShowHistoryComponent},
  {path: 'errorValidation', component: ErrorValidationComponent},
  {path: 'lastAdded', component: LastAddedComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
