import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app.routing.module';
import {AppComponent} from './app.component';
import {AppLayoutComponent, FooterComponent, HeaderComponent, SidebarComponent} from './_layout';
import {ApiService} from './services/api.service';
import {IssueService} from "./services/shared/issue.service";
import {ProjectService} from "./services/shared/project.service";
import {HttpClientModule, HttpClient} from "@angular/common/http";
import {BsDatepickerModule, BsDropdownModule, CollapseModule, ModalModule, PaginationModule} from "ngx-bootstrap";
import {ToastNoAnimation, ToastNoAnimationModule, ToastrModule} from "ngx-toastr";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxDatatableModule,
    CollapseModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot(),
    ToastNoAnimationModule,
    ToastrModule.forRoot({
      toastComponent: ToastNoAnimation,
      maxOpened:1,
      autoDismiss:true
    }),
    TranslateModule.forRoot({
      loader: {
        provide:TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    }),
  ],
  providers: [ApiService,IssueService,ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
