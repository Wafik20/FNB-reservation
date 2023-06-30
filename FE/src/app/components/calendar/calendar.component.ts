import { Component, ViewChild } from '@angular/core';
import { WeekdayComponent } from '../weekday/weekday.component';


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent {
  @ViewChild(WeekdayComponent ) child!: WeekdayComponent ; 

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

  // Function called getTimes
  getTimes(): void {
   
    console.log(this.child.sendTimes());
    

    for (let i = 0; i < this.child.sendTimes().length; i++) {
      this.isabella1.push(this.child.sendTimes()[i]);
      console.log("Isabella1: " + this.isabella1);
    }


  }
}
