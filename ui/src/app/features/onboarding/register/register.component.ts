import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

export interface LaptopPreferenceModel {
  value: string;
  viewValue: string;
}

export class CandidateDetails {
  firstname: string;
  surname: string;
  startdate: string;
  noticeperiod: string;
  email: string;
  address: string;
  contactnumber: string;
  laptoppreference: string;
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  candidateForm: FormGroup;

  laptopPreferenceOptions: LaptopPreferenceModel[] = [
    {value: 'dell', viewValue: 'Dell'},
    {value: 'macbookair', viewValue: 'Mac Book Air'},
    {value: 'macbookpro', viewValue: 'Mac Book Pro'}
  ];

  constructor(private fb: FormBuilder, private http: HttpClient, 
    private router:Router, private snackBar: MatSnackBar) { }

  ngOnInit() { 
    this._buildForm(new CandidateDetails());
  }


  getEmailErrorMessage() {
    return this.candidateForm.get('email').hasError('required') ? 'Email address cannot be empty' :
        this.candidateForm.get('email').hasError('email') ? 'Not a valid email' :
            '';
  }

  getFirstnameErrorMessage() {
    return this.candidateForm.get('firstname').hasError('required') ? 'First name cannot be empty' :
        this.candidateForm.get('firstname').hasError('pattern') ? 'Not a valid first name' :
            '';
  }

  getSurnameErrorMessage() {
    return this.candidateForm.get('surname').hasError('required') ? 'Surname cannot be empty' :
        this.candidateForm.get('surname').hasError('pattern') ? 'Not a valid surname' :
            '';
  }

  getStartDateErrorMessage() {
    return this.candidateForm.get('startdate').hasError('required') ? 'Start date cannot be empty' :
            '';
  }

  getNoticeperiodErrorMessage() {
    return this.candidateForm.get('noticeperiod').hasError('required') ? 'Notice period cannot be empty' :
            '';
  }

  getContactNumberMessage() {
    return this.candidateForm.get('contactnumber').hasError('required') ? 'Contact number cannot be empty' :
          this.candidateForm.get('contactnumber').hasError('pattern') ? 'Not a valid contact number' :
            '';
  }

  getAddressErrorMessage() {
    return this.candidateForm.get('address').hasError('required') ? 'Address cannot be empty' :
            '';
  }

  getLaptopPreferenceErrorMessage() {
    return this.candidateForm.get('laptoppreference').hasError('required') ? 'Laptop preference needs to be selected' :
            '';
  }

  saveCandidateForm() {
    return this.http.post(environment.baseUrl + 'candidate/onboarding/register', this.candidateForm.value)
      .subscribe(response => {
        console.log('Response: ' + response);
        this.snackBar.open("You have successfully registered " + this.candidateForm.value.firstname, 'Registered', {
          duration: 2000,
        });
      })
  }

  clearAction() {
    this._buildForm(new CandidateDetails());
  }

  private _buildForm(candidateDetails) {
    this.candidateForm = this.fb.group({
      'firstname': [candidateDetails.firstname, [Validators.required, Validators.pattern('[a-zA-Z ]+')]],
      'surname': [candidateDetails.surname, Validators.required, Validators.pattern('[a-zA-Z ]+')],
      'startdate': [candidateDetails.startdate],
      'noticeperiod': [candidateDetails.noticeperiod],
      'email': [candidateDetails.email, [Validators.required, Validators.email]],
      'address': [candidateDetails.address],
      'contactnumber': [candidateDetails.conctactnumber, [Validators.required, Validators.pattern('[0-9]+')]],
      'laptoppreference': [candidateDetails.laptoppreference]
    });
  }

}
