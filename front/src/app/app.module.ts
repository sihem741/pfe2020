import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {AddProductComponent} from './add-product/add-product.component';
import {ShowHistoryComponent} from './show-history/show-history.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatRadioModule} from "@angular/material/radio";
import {HttpClientModule} from "@angular/common/http";
import {MatTableModule} from "@angular/material/table";
import {ErrorValidationComponent} from './error-validation/error-validation.component';
import {ValidationErrorFormComponent} from './validation-error-form/validation-error-form.component';
import {MatDialogModule} from "@angular/material/dialog";
import { LastAddedComponent } from './last-added/last-added.component';
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ShowHistoryComponent,
    ErrorValidationComponent,
    ValidationErrorFormComponent,
    LastAddedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCheckboxModule,
    MatRadioModule, HttpClientModule, MatTableModule, MatDialogModule,MatSnackBarModule
  ],
  entryComponents: [
    ValidationErrorFormComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
