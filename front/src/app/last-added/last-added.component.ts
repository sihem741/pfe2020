import { Component, OnInit } from '@angular/core';
import {ServiceService} from "../app.service.service";

@Component({
  selector: 'app-last-added',
  templateUrl: './last-added.component.html',
  styleUrls: ['./last-added.component.css']
})
export class LastAddedComponent implements OnInit {

  displayedColumns: string[] = ['matricule', 'name', 'user', 'isDefective', 'actions'];
  dataSource: any;

  constructor(private service: ServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
  }


  getAll() {
    this.service.getLastAdded().subscribe((res) => {
      this.dataSource = res
    });
  }

}
