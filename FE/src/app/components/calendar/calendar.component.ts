import { Component, ViewChild } from '@angular/core';
import { WeekdayComponent } from '../weekday/weekday.component';


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent {
  @ViewChild(WeekdayComponent ) child!: WeekdayComponent ; 

  // Function called getTimes
  getTimes(): void {
   

    // Call a function that is in a child component
    console.log(this.child.sendTimes());


  }
}
