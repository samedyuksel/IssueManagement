import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from 'src/app/services/shared/project.service';
import {Page} from "../../common/page";
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';


@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  page = new Page();
  cols = [
    {prop: 'id', name:'No'},
    {prop: 'projectName', name:'Project Name', sortable: true},
    {prop: 'projectCode', name:'Project Code', sortable: false},
  ];
  rows = [];

  modalRef: BsModalRef;
    constructor(private projectService: ProjectService, private modalService: BsModalService) {}

  ngOnInit(){
      this.setPage({offset: 0});
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  setPage(pageInfo){
      this.page.page = pageInfo.offset;
      this.projectService.getAll(this.page).subscribe(pagedData => {
        this.page.size = pagedData.size;
        this.page.page = pagedData.page;
        this.page.totalElements = pagedData.totalElements;
        this.rows = pagedData.content;
      })
  }

}