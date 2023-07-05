import { Component, ViewChild } from '@angular/core';
import { WeekdayComponent } from '../weekday/weekday.component';
import { getCurrencySymbol } from '@angular/common';


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent {
  @ViewChild(WeekdayComponent ) child!: WeekdayComponent ;

  date!: string;

  //  Dummy data containing created reservations
  reservations = [
    {
      room: "isabella1",
      date: "Fri Jul 07 2023 00:00:00 GMT-0400 (Eastern Daylight Time)",
      times: [
      '7:00',
      '7:15',
      '7:30']

    },

    {
      room: "isabella1",
      date: "Sun Jul 09 2023 00:00:00 GMT-0400 (Eastern Daylight Time)",
      times: [
      '8:00',
      '8:15',
      '8:30']

    },


    {
      room: "isabella2",
      date: "Fri Jul 08 2023 00:00:00 GMT-0400 (Eastern Daylight Time)",
      times: [
      '10:00',
      '10:15',
      '10:30']
    }
  ]

  // A test array that stores data for a specific date
  testIsa1 = ["",
  '8:00',
  '8:15',
  '8:30'];

  // This checks all reservations on a given date and room and pushes the reserved times to the test array
  // This data must be re-passed to the child upon changing the time or adding reservations
  getReserved(): void {

    // Clears the selected room's array
    this.testIsa1.length = 0;

    console.log(this.date);
    console.log(this.reservations[0].date);

    // For each reservation...
    for (let i = 0; i < this.reservations.length; i++) {

      // ...if the date matches...
      if (this.reservations[i].date == this.date) {

        // ...push the reserved times to the isabella array- which is passed to the child component
        for (let x = 0; x < this.reservations[i].times.length; x++) {

          // Log the times that are in the reservation
          console.log("RESERVED: " + this.reservations[i].times)

          // Switch statement for rooms?
          this.testIsa1.push(this.reservations[i].times[x])
        }
      }

    }

    console.log(this.testIsa1);
  }

  isabella1 = [
    '7:00',
    '7:15',
    '7:30',
    '7:45',
    '8:00',
    '8:15',
    '8:30',
  ];

  isabella2 = [
    '11:00',
    '11:15',
    '11:30',
    '11:45',
  ];

  // Submits the date that the user chose (sends to API and gets availability for each room)
  sendDate(): void {

  }

  booking = {date: "", times: []}

  // Gets sends the times that the user selected
  getTimes(): void {

    // Calls the child components' "sendTimes" function, which returns the selected times
    console.log("Response from child: " + this.child.sendTimes() + " in " + this.child.sendRoom());
    let timesArray = this.child.sendTimes();

    console.log("Times array: " + timesArray);

    // It then pushes those values to the reservations array for the given room

    // For each of the selected times...
    for (let i = 0; i < timesArray.length; i++) {

      // ...for each reservation date...
      for (let x = 0; x < this.reservations.length; x++) {
        const current = this.reservations[x];

        // if the current one matches today's date...
        if (current.date == this.date) {

          // add the time to the array of booked times
          current.times.push(timesArray[i]);
        }
        // Else create a new reservation with date and room
        //

      }
    }


  }
}
