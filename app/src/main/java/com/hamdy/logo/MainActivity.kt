package com.hamdy.logo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.hamdy.logo.components.MyTopAppBar
import com.hamdy.logo.components.PostActions

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { MyTopAppBar() },
                content = { PostActions() }
            )


        }
    }
}



