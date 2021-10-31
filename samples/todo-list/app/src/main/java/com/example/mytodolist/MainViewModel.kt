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

    fun toggleTodo(todo: Todo) {
        todoList.value = todoList.value.map {
            if (it == todo) {
                it.copy(isDone = !it.isDone)
            } else {
                it
            }
        }
    }
}

enum class Routes {
    TodoList,
    AddTodo
}

val MainViewModelProvider = Provider {
    retainInHost { MainViewModel() }
}