import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Todo } from 'src/app/model/Todo';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
  
  //input decorator
  @Input() todo: Todo;
  @Input() i?: number;

  @Output() todoDelete: EventEmitter<Todo> = new EventEmitter();
  @Output() todoCheckbox: EventEmitter<Todo> = new EventEmitter();

  constructor() {
    this.todo = new Todo();
  }

  onClick(todo: Todo){
    this.todoDelete.emit(todo);  
    console.log("onclick has been Clicked");
  }

  onCheckboxClick(todo: Todo){
    this.todoCheckbox.emit(todo); 
    console.log("onCheckboxClick has been Clicked");
  }

  ngOnInit(): void {
  }
}
