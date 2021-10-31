package com.example.mytodolist.ui.todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodolist.MainViewModelProvider
import com.example.mytodolist.Todo

@Composable
fun TodoListScreen(
        onAddTodoClicked: () -> Unit,
        onTodoToggled: (Todo) -> Unit
) {
    val vm = MainViewModelProvider.get()
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onAddTodoClicked,
                    content = {
                        Image(
                            imageVector = Icons.Default.Add,
                            contentDescription = null
                        )
                    },
                )
            },
            content = {
                TodoList(vm.todoList.value, onTodoToggled)
            },
        )
    }
}

@Composable
fun TodoList(
        todoList: List<Todo>,
        onToggle: (Todo) -> Unit
) {
    LazyColumn {
        items(todoList) { item ->
            Row {
                Checkbox(checked = item.isDone, onCheckedChange = { onToggle(item) })
                Text(text = item.title)
            }
        }
    }
}

@Preview
@Composable
fun TodoListPreview() {
    TodoList(todoList = List(5) {
        Todo(
            title = "Title $it",
            isDone = it > 3
        )
    },
    onToggle = {})
}