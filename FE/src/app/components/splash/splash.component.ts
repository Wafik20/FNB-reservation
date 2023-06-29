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

  roomSelected = "Room 1";


  // An array of reservations called bookings that includes the date, time, and room number of each
  bookings = [
    {date: "Thu Jun 29 2023 00:00:00 GMT-0400 (Eastern Daylight Time)", time: "eight-am", room: "Room 1"},
    {date: "Thu Jun 29 2023 00:00:00 GMT-0400 (Eastern Daylight Time)", time: "ten-am", room: "Room 1"},
  ]

  Submit() {
   

    // Display the name, date, time, and length fields in the console
    console.log(this.name);
    console.log(this.date)
    console.log(this.startTime)
    console.log(this.length)
    console.log(this.bookings[0].date)
    console.log(this.bookings[0].time)
    console.log(this.bookings[0].room)
    console.log(this.roomSelected)
    


    // If any of the fields are empty, display an error message
    if (this.name == null || this.date == null || this.startTime == null || this.length == null) {
      this._snackBar.open("Please fill out all fields", "Okay");
    } else {

      var NotAvailable = false;
      for (var i = 0; i < this.bookings.length; i++) {
        if (this.bookings[i].date == this.date && this.bookings[i].time == this.startTime && this.bookings[i].room == this.roomSelected) {
          NotAvailable = true;
          console.log("Not available");
          this._snackBar.open("Unavailable", "Okay");
          console.log(this.bookings[i].date)
          
          break;
        } 
      }

      if (NotAvailable == false) {
        this._snackBar.open("Room Reserved", "Okay");
        
        // In the future, this will send the data to the database
        this.bookings.push({date: this.date, time: this.startTime, room: this.roomSelected});
        console.log(this.bookings);
        
      }
      else {
        this._snackBar.open("Unavailable", "Okay");
      }
      

      
    }




  }
}