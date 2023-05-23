package com.example.todoappcompose.Screeens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todoappcompose.route.BottomBarScreen
import com.example.todoappcompose.route.BottomNavGraph
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home")},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector= Icons.Default.Menu, contentDescription = "Home Menu Icon")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Menu Icon")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings Menu Icon")
                    }
                }

            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues ->
        BottomNavGraph(navController = navController, paddingValues = paddingValues )
        
    }
    
    
    
}


@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Add,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(){
        screens.forEach{ screen ->
            NavigationBarItem(
                label = { Text(text = screen.title)},
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = screen.title)
                },
                selected = currentDestination?.hierarchy?.any(){it.route == screen.route} == true,
                onClick = {
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState=true
                        }
                        launchSingleTop=true
                        restoreState = true
                    }

                }
            )

        }
    }
}























