import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Product} from "../models/product";
import {ServiceService} from "../app.service.service";

@Component({
  selector: 'app-validation-error-form',
  templateUrl: './validation-error-form.component.html',
  styleUrls: ['./validation-error-form.component.css']
})
export class ValidationErrorFormComponent implements OnInit {

  showCause = true;

  constructor(
    public dialogRef: MatDialogRef<ValidationErrorFormComponent>,
    @Inject(MAT_DIALOG_DATA) public product: Product, private sercice: ServiceService) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onItemChange(event) {
    console.log(this.product, this.showCause)

    this.showCause = event.value == 'true' ? true : false;

  }

  submitProduct() {
    this.sercice.editProduct(this.product).subscribe();
  }
}
