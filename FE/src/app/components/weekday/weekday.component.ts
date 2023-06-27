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
    taken: ["2:00", "2:15", "2:30", "2:45", "10:00", "10:15"],
  }

  isabella2 = {
    taken: ["5:00", "5:15", "5:30"],
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
}
