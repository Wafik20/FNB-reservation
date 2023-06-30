import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-weekday',
  templateUrl: './weekday.component.html',
  styleUrls: ['./weekday.component.scss']
})
export class WeekdayComponent {


  getRange(limit: number): number[] {
    return Array.from({ length: limit }, (_, i) => i);
  }

  // Matching the time to the input
  selected: string = '7:30';
  @Input() room!: string;

  @Input() date!: string;




  isabella1 = {
    taken: ["6:00", "6:15", "7:30", "7:45", "11:00"],
  }

  isabella2 = {
    taken: ["9:00", "9:15", "10:30", "10:45", "11:00"],
  }

  roomCheck(x: string): boolean {
    switch (this.room) {
      case "isabella1":
        if(this.isabella1.taken.includes(x)) {
          return true;
        }
        else return false;
        break;

      case "isabella2":
        if(this.isabella2.taken.includes(x)) {
          return true;
        }
        else return false;
        break;

      default:
        return false;
        break;
    }

  }

  // Array of times that are selected
  selectedTimes: string[] = [];

  // Display the value from a child's event emitter to the console
  logTime(time: string) {
    console.log(time);
  }

  addTime($time: string) {

    // If the time is already in the array, remove it
    if (this.selectedTimes.includes($time)) {
      this.selectedTimes.splice(this.selectedTimes.indexOf($time), 1);
    }
    else {
      this.selectedTimes.push($time);
    }

    console.log(this.selectedTimes);
  
  }
}
