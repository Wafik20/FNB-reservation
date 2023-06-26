import { Component } from '@angular/core';

import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';




@Component({
  selector: 'app-splash',
  templateUrl: './splash.component.html',
  styleUrls: ['./splash.component.scss']
})
export class SplashComponent {
  startTime!: string;

  times = [
    {value: 'eight-am', viewValue: '8am'},
    {value: 'nine-am', viewValue: '9am'},
    {value: 'ten-am', viewValue: '10am'},
    {value: 'eleven-am', viewValue: '11am'},
    {value: 'twelve-pm', viewValue: '12pm'},
    {value: 'one-pm', viewValue: '1pm'},
    {value: 'two-pm', viewValue: '2pm'},
    {value: 'three-pm', viewValue: '3pm'},
    {value: 'four-pm', viewValue: '4pm'},
    {value: 'five-pm', viewValue: '5pm'}
  ];


  // Slider

  formatLabel(value: number): string {
    return `${value}`;
  }


  // Snackbar

  constructor(private _snackBar: MatSnackBar) {}


  // Variables for the form that include start date, name, time, and length
  startDate = new Date();
  name!: string;
  date!: string;
  length!: string;




  Submit() {
    this._snackBar.open("Meeting reserved! 🎉", "Okay");

    // Display the name, date, time, and length fields in the console
    console.log(this.name);
    console.log(this.date)
    console.log(this.startTime)
    console.log(this.length)

    // If any of the fields are empty, display an error message
    if (this.name == null || this.date == null || this.startTime == null || this.length == null) {
      this._snackBar.open("Please fill out all fields", "Okay");
    }
    



  }
}
