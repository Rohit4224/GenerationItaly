import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Todo } from 'src/app/model/Todo';

@Component({
  selector: 'add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css']
})
export class AddTodoComponent implements OnInit{
  title:string  = "";
  desc:string   = "";

  @Output() todoAdd: EventEmitter<Todo> = new EventEmitter();

  constructor() { }
  ngOnInit(): void {
  }
  onSubmit(){
    console.log("onSubmit has been Clicked");
    const todo = {
      sno:8,
      title:this.title,
      desc:this.desc,
      active:true
    }

    this.todoAdd.emit(todo);
  }
}
