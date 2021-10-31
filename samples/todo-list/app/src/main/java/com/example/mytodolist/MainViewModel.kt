package com.example.mytodolist

import androidx.compose.runtime.mutableStateOf
import dev.marcellogalhardo.staccato.core.Provider
import dev.marcellogalhardo.staccato.core.retainInHost

class MainViewModel {

    val currentRoute = mutableStateOf(Routes.TodoList)

    val todoList = mutableStateOf(emptyList<Todo>())

    fun navigateToAddTodo() {
        currentRoute.value = Routes.AddTodo
    }

    fun navigateToTodoList() {
        currentRoute.value = Routes.TodoList
    }

    fun addTodo(todo: Todo) {
        todoList.value = todoList.value + todo
    }
}

enum class Routes {
    TodoList,
    AddTodo
}

val MainViewModelProvider = Provider {
    retainInHost { MainViewModel() }
}
