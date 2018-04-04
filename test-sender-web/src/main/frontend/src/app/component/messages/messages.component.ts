import { Component, OnInit } from '@angular/core';
import {Message} from '../../model/message.model';
import {TestService} from '../../service/test.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  messages: Message[];

  constructor(public testService: TestService) { }

  ngOnInit() {
    this.updateMessages();
  }

  updateMessages() {
    this.testService.getMessages().subscribe(
      data => {
        console.log('Messages received: ' + data);
        this.messages = <Message[]>data.json();
      },
      error => {
        console.log('Error occured: ' + error);
      }
    );
  }

}
