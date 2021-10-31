package com.example.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.marcellogalhardo.staccato.core.StaccatoHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StaccatoHost(isChangingConfigurations = { isChangingConfigurations }) {
                MainView()
            }
        }
    }
}
