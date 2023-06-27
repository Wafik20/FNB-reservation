import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-caltimeslot',
  templateUrl: './caltimeslot.component.html',
  styleUrls: ['./caltimeslot.component.scss']
})
export class CaltimeslotComponent {
  @Input() marker!: string;

  @Input() time!: string;

  selected!: string;
}
