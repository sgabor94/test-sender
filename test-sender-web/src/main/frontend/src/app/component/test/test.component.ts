import {Component, OnInit} from '@angular/core';
import {TestMessage} from '../../model/testmessage.model';
import {TestService} from '../../service/test.service';
import {AlertService} from '../../service/alert.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  testMessage: TestMessage;

  constructor(private testService: TestService, private alertService: AlertService) {
  }

  ngOnInit() {
    this.testMessage = new TestMessage();
  }

  sendMessage() {
    if (this.testMessage.message != null && this.testMessage.dateReceived != null) {
      this.testService.sendMessage(this.testMessage).subscribe(
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
