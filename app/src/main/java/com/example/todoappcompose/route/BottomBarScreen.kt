package com.example.todoappcompose.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route:String,
    val title:String,
    val icon: ImageVector
){

    object Home:BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Add:BottomBarScreen(
        route = "add",
        title = "Add",
        icon = Icons.Default.Add
    )

    object Settings:BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )


}
