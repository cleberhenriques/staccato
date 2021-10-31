package com.example.mytodolist.ui.todo

import androidx.compose.foundation.Image
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
                TodoList(vm.todoList.value)
            },
        )
    }
}

@Composable
fun TodoList(todoList: List<Todo>) {
    LazyColumn {
        items(todoList) { item ->
            Text(text = item.title)
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
    })
}
