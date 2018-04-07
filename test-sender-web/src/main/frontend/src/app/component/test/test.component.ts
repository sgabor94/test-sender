import {Component, OnInit} from '@angular/core';
import {TestService} from '../../service/test.service';
import {AlertService} from '../../service/alert.service';
import {Message} from '../../model/message.model';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  message: Message;

  constructor(private testService: TestService, private alertService: AlertService) {
  }

  ngOnInit() {
    this.message = new Message();
  }

  sendMessage() {
    if (this.message.content != null && this.message.sendDate != null) {
      this.testService.sendMessage(this.message).subscribe(
        () => {
          this.alertService.success('Message sent!');
        },
        error => {
          console.log('Error: ' + error);
          this.alertService.error('Error occurred during sending message!');
        }
      );
    } else {
      this.alertService.error('Cannot send message without Message and Date received fields');
    }
  }

}
