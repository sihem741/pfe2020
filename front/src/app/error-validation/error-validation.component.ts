import {Component, OnInit} from '@angular/core';
import {ServiceService} from "../app.service.service";
import {ValidationErrorFormComponent} from "../validation-error-form/validation-error-form.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-error-validation',
  templateUrl: './error-validation.component.html',
  styleUrls: ['./error-validation.component.css']
})
export class ErrorValidationComponent implements OnInit {

  displayedColumns: string[] = ['matricule', 'name', 'user', 'isDefective', 'actions'];
  dataSource: any;

  constructor(private service: ServiceService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getDefected();
  }


  getDefected() {
    this.service.getDefected().subscribe((res) => {
      console.log(res);
      this.dataSource = res
    });
  }

  openDialog(row): void {
    const dialogRef = this.dialog.open(ValidationErrorFormComponent, {
      width: '250px',
      data: row
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
