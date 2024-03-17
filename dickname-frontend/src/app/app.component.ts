import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, FormsModule, NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'dickname';
  name: string = '';
  response: string = '';
  showFireworks: boolean = false;
  hasBeenFocused: boolean = false;

  constructor(private http: HttpClient) { }

  sendName() {
    this.http.post<{dickName: string}>('/api/generate/dickname', { name: this.name })
      .subscribe(data => {
        this.response = data.dickName;
        this.showFireworks = true;
        setTimeout(() => this.showFireworks = false, 3000); // Примерное время показа салютов
      });
  }

  resetForm() {
    this.response = '';
    this.name = '';
    this.showFireworks = false;
  }
}
