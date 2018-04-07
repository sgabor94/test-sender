import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './component/header/header.component';
import {HomeComponent} from './component/home/home.component';
import {AboutComponent} from './component/about/about.component';
import {AlertComponent} from './component/alert/alert.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {AlertService} from './service/alert.service';
import {CommonService} from './service/common.service';
import { MessagesComponent } from './component/messages/messages.component';
import {TestService} from './service/test.service';
import { TestComponent } from './component/test/test.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'messages', component: MessagesComponent},
  {path: 'send', component: TestComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AboutComponent,
    AlertComponent,
    MessagesComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    HttpModule,
    RouterModule.forRoot(appRoutes, {useHash: true})
  ],
  providers: [AlertService, CommonService, TestService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
