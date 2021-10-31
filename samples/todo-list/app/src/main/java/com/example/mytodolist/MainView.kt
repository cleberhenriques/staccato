package com.example.mytodolist

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodolist.ui.theme.MyTodoListTheme
import com.example.mytodolist.ui.todo.AddTodoScreen
import com.example.mytodolist.ui.todo.TodoListScreen
import dev.marcellogalhardo.staccato.core.retainInHost


@Composable
internal fun MainView() {
    val vm = MainViewModelProvider.get()
    val state by vm.currentRoute

    val context = LocalContext.current
    BackHandler {
        when (state) {
            Routes.TodoList -> (context as ComponentActivity).finish()
            Routes.AddTodo -> vm.navigateToTodoList()
        }
    }

    MyTodoListTheme {
        when (state) {
            Routes.TodoList -> TodoListScreen(
                onAddTodoClicked = {
                    vm.navigateToAddTodo()
                }
            )
            Routes.AddTodo -> AddTodoScreen(
                onNavigationIconClicked = {
                    vm.navigateToTodoList()
                }
            )
        }
    }
}


class Todo(
        val title: String,
        val isDone: Boolean
)
