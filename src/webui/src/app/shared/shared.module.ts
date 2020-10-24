import {NgModule} from "@angular/core";
import {TranslateModule} from "@ngx-translate/core";
import {BsModalRef, ModalModule} from "ngx-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

// confirmation eklenecek

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers: [BsModalRef],
  declarations: [
  ],
  entryComponents: [
  ],
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule
  ]
})
export class SharedModule {
}
