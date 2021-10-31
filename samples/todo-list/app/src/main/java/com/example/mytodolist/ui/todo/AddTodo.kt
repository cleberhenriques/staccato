package com.example.mytodolist.ui.todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.example.mytodolist.MainViewModelProvider
import com.example.mytodolist.Todo

@Composable
fun AddTodoScreen(
        onNavigationIconClicked: () -> Unit,
) {
    val vm = MainViewModelProvider.get()
    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New todo") },
                navigationIcon = {
                    IconButton(onClick = onNavigationIconClicked) {
                        Image(
                            imageVector = Icons.Default.ArrowBack,
                            colorFilter = ColorFilter.tint(Color.White),
                            contentDescription = null
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val todo = Todo(title = title, isDone = false)
                    vm.addTodo(todo)
                    vm.navigateToTodoList()
                },
                content = { Image(Icons.Default.Done, contentDescription = null) },
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(all = 16.dp),
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it },
            )
        }
    }
}
