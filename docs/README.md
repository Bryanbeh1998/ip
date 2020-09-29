# User Guide

## Features 
###Duke is a platform to keep track and organise your tasks
Duke can keep track of your todos,events and deadlines. Furthermore, Duke can show the
full list and implement helpful commands such as deleting tasks, marking tasks as 
done and  finding tasks


## Usage

### `todo <description>` - Adds a Todo item

Adds a todo item with the description, then it adds to the list of tasks

A message indicating the task has been added and the number of tasks in the list will be shown

Example of usage: 

`todo cycling`

Expected outcome:

`Got it. I've added this task:[T][x] cycling`
 
`Now you have 1 task(s) in your list!'`

### `deadline <description> /by <date>` - Adds a deadline item

Adds a deadline item with the description and the deadline date,then it adds to the list of tasks

A message indicating the task has been added and the number of tasks in the list will be shown

 Example of usage: 
 
 `deadline ip /by 2 Oct`
 
 Expected outcome:
 
 `Got it. I've added this task:[D][PENDING] ip (by: 2 Oct)`
 
 `Now you have 2 task(s) in your list!`

### `event <description> /at <startDate>` - Adds an event item

Adds an event item with the description and the start date,then it adds to the list of tasks

A message indicating the task has been added and the number of tasks in the list will be shown

 Example of usage: 
 
 `event basketball competition /at 9 Jan`
 
 Expected outcome:
 
`Got it. I've added this task:[E][PENDING] basketball competition (at: 9 Jan)`

`Now you have 3 task(s) in your list!`

### `list` - Shows the list of tasks

Produces a list of all the tasks in the list at that instance

 Example of usage: 
 
 `list`
 
 Expected outcome:
 
`Here are the tasks in your list:`

`1.[T][PENDING] cycling`

`2.[D][PENDING] ip (by: 2 Oct)`

`3.[E][PENDING] basketball competition (at: 9 Jan)`

### `delete <index>` - Deletes a task from the task list

Deletes a task of the given index from the task list.

A message indicating that the task has been deleted the current number 
of tasks in the list will be shown.

 Example of usage: 
 
 `delete 1`
 
 Expected outcome:
 
 `Noted! i have removed this task from your list: [T][PENDING] cycling`
 
` Now only you have 2 task(s) in your list`

### `done <index>` - Marks task as done

Marks a task of the given index as done in the task list.

A message indicating that the task has been marked as done the current number 
of tasks in the list will be shown.

 Example of usage: 
 
 `done 1`
 
 Expected outcome:
 
 `Nice! I've marked this task as done:[D][DONE] ip (by: 2 Oct)`
 
 `Now you have 2 task(s) in your list!`
 
 ### `find <description>` - List all tasks which contain the description
 
 Finds all tasks which contains the given description. Duke then prints it all in a list and
 returns it to the user.
 
 
  Example of usage: 
  
  `find ip`
  
  Expected outcome:
  
 ` 1.[D][DONE] ip (by: 2 Oct)`
 
  ### `bye`- Exits the program
  
 Ends and exits the application
  
  
   Example of usage: 
   
   `bye`
   
   Expected outcome:
   
  ` Bye ! Hope to see you again`
 