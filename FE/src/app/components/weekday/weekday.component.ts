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

  time: string = '8:00';


  @Input() date!: string;


  taken: string[] = ["8:00", "8:15", "8:30", "8:45", "10:00", "10:15"];
}
