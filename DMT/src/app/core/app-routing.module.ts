import {NgModule}  from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from '../user/user.component';
import {LoginComponent} from '../login/login.component';
import {MappingComponent} from '../mapping/mapping.component';
import { SuccessComponent } from '../success/success.component';
const routes: Routes = [
  { path : 'success', component:SuccessComponent},
  { path: 'mapping', component: MappingComponent },
  { path: 'user', component: UserComponent },
  { path: 'login', component: LoginComponent },
  {path : '', component : LoginComponent}
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }