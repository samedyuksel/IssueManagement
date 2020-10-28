import { Component, OnInit } from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {Subject} from "rxjs";
import {TranslateModule} from "@ngx-translate/core";

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.scss']
})
export class ConfirmationComponent implements OnInit {

   body: string;
   header: string;
   onClose: Subject<boolean>;
   active: boolean;

  constructor(private bsModalRef: BsModalRef) { }

  ngOnInit() {
    this.onClose = new Subject();
  }

  public showConfirmation(header: string, body: string):void {
    this.body = body;
    this.header = header;
    this.active = true;
  }

  onConfirm() {
    this.active = false;
    this.onClose.next(true);
    this.bsModalRef.hide();
  }

  onCancel() {
    this.active = false;
    this.onClose.next(false)
    this.bsModalRef.hide();
  }

}
