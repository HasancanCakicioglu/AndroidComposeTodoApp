package com.example.todoappcompose.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.todoappcompose.Screeens.AddScreen
import com.example.todoappcompose.Screeens.HomeScreen
import com.example.todoappcompose.Screeens.SettingsScreen


@Composable
fun BottomNavGraph(navController:NavHostController,paddingValues:PaddingValues){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ){
        composable(route=BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route=BottomBarScreen.Add.route){
            AddScreen()
        }
        composable(route=BottomBarScreen.Settings.route){
            SettingsScreen()
        }
    }
}