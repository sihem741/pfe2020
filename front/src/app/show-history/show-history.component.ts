import {Component, OnInit} from '@angular/core';
import {ServiceService} from "../app.service.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-show-history',
  templateUrl: './show-history.component.html',
  styleUrls: ['./show-history.component.css']
})
export class ShowHistoryComponent implements OnInit {
  displayedColumns: string[] = ['matricule', 'name', 'user', 'isDefective', 'actions'];
  dataSource: any[];

  constructor(private service: ServiceService,private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getAll();
  }


  getAll() {
    this.service.getAll().subscribe((res) => {
      console.log(res);
      this.dataSource = res
    });
  }

  deleteProduct(row: any) {
    this.service.deleteProduct(row).subscribe(
      () => {this.dataSource = this.dataSource.filter((item) => item.id !== row.id)
      this.openSnackBar("Produit supprimé avec succée")}
    );
  }
  openSnackBar(message: string) {
    this._snackBar.open(message, "",{
      duration: 4000,horizontalPosition:"right",verticalPosition:"top"
    });
  }
}
