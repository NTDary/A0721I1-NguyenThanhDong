import {Component, OnInit} from '@angular/core';
import {ComponentService} from '../services/component.service';
import {SinhVienModel} from '../models/sinhVienModel';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  listSinhVien: SinhVienModel[];

  constructor(private service: ComponentService) {
  }

  ngOnInit(): void {
    this.service.getList().subscribe(next => this.listSinhVien = next);
  }
}
