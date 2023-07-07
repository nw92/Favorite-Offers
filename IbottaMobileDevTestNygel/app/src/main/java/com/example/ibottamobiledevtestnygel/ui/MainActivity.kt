package com.example.ibottamobiledevtestnygel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.ibottamobiledevtestnygel.navigation.NavGraph
import com.example.ibottamobiledevtestnygel.ui.theme.IbottaMobileDevTestNygelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IbottaMobileDevTestNygelTheme {
                NavGraph(navHostController = rememberNavController())
            }
        }
    }
}
