import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import {IssueRoutingModule} from "./issue.routing.module";
import { IssueService } from 'src/app/services/shared/issue.service';
import {SharedModule} from "../../shared/shared.module";


@NgModule({
  declarations: [IssueComponent],
  providers:[IssueService],
  imports: [
    CommonModule,
    IssueRoutingModule,
    SharedModule
  ]
})
export class IssueModule { }
