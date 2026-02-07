package com.example.agentx.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.agentx.ui.screens.AgentScreen
import com.example.agentx.ui.screens.HistoryScreen
import com.example.agentx.ui.screens.InputScreen
import com.example.agentx.ui.screens.SettingsScreen
import com.example.agentx.ui.screens.TodayScreen

private enum class AppDestination(val route: String, val label: String) {
    Today("today", "Сегодня"),
    Agent("agent", "Агент"),
    Input("input", "Ввод"),
    History("history", "История"),
    Settings("settings", "Настройки")
}

@Composable
fun AgentXApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                val destinations = listOf(
                    AppDestination.Today to Icons.Filled.CalendarToday,
                    AppDestination.Agent to Icons.Filled.ChatBubbleOutline,
                    AppDestination.Input to Icons.Filled.Edit,
                    AppDestination.History to Icons.Filled.History,
                    AppDestination.Settings to Icons.Filled.Settings
                )
                destinations.forEach { (destination, icon) ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(imageVector = icon, contentDescription = destination.label) },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Today.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(AppDestination.Today.route) { TodayScreen() }
            composable(AppDestination.Agent.route) { AgentScreen() }
            composable(AppDestination.Input.route) { InputScreen() }
            composable(AppDestination.History.route) { HistoryScreen() }
            composable(AppDestination.Settings.route) { SettingsScreen() }
        }
    }
}
