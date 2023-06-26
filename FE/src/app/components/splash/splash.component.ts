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
    {value: '8', viewValue: '8am'},
    {value: '9', viewValue: '9am'},
    {value: '10', viewValue: '10am'},
    {value: '11', viewValue: '11am'},
    {value: '12', viewValue: '12pm'},
    {value: '1', viewValue: '1pm'},
    {value: '2', viewValue: '2pm'},
    {value: '3', viewValue: '3pm'},
    {value: '4', viewValue: '4pm'},
    {value: '5', viewValue: '5pm'}
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
  length!: number;




  Submit() {
    this._snackBar.open("Meeting reserved! 🎉", "Okay");

    // Display the name, date, time, and length fields in the console
    console.log(this.name);
    console.log(this.date);
    console.log(this.startTime);
    console.log(this.length);
    console.log("Slices:" + (this.length * 60));

    // If any of the fields are empty, display an error message
    if (this.name == null || this.date == null || this.startTime == null || this.length == null) {
      this._snackBar.open("Please fill out all fields", "Okay");
    }





  }
}
