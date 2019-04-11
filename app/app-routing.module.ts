import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
   {path: '' , redirectTo: '/homepage', pathMatch: 'full'},
  {path: 'home/:email', component: ProfileComponent},
  {path: 'updateprofile/:email', component: ProfileComponent},
  {path: 'profile/:email', component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
