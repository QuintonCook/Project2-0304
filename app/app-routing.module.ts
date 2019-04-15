import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { UpdateComponent } from './update/update.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { FeedComponent } from './feed/feed.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { InsertComponent } from './insert/insert.component';
import { SendEmailComponent } from './send-email/send-email.component';

const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'update-profile', component: UpdateComponent },
  { path: 'view-profile/:email', component: ProfileComponent },
  { path: 'about-profile', component: AboutComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'feed', component: FeedComponent },
  { path: 'search', component: SearchResultsComponent},
  { path: 'insert', component: InsertComponent},
  { path: 'sendemail', component: SendEmailComponent},
  { path: 'resetpassword', component: ResetPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
