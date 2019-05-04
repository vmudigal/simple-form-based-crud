import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './features/onboarding/register/register.component';
import { CandidatesComponent } from './features/onboarding/candidates/candidates.component';

const routes: Routes = [
  {path:"", component: HomeComponent},
  {path:"onboarding/register", component: RegisterComponent},
  {path:"onboarding/list", component: CandidatesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
