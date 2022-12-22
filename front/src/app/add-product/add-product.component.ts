import {Component, OnInit} from '@angular/core';
import {Product} from "../models/product";
import {ServiceService} from "../app.service.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product: Product = new Product();
  sessionForm: FormGroup;

  constructor(private service: ServiceService,private _snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.sessionForm = new FormGroup({
      'name': new FormControl(null, Validators.required),
      'matricule': new FormControl(null, Validators.required),
      'user': new FormControl(null, Validators.required),
      'flan': new FormControl(null, Validators.required),
      'isDefective': new FormControl(null, Validators.required),

    });
  }

  submitProduct() {
    this.service.addProduct(this.sessionForm.value).subscribe(()=>this.openSnackBar("Produit ajouté avec succes"));
  }
  openSnackBar(message: string) {
    this._snackBar.open(message, "",{
      duration: 4000,horizontalPosition:"right",verticalPosition:"top"
    });
  }

}
