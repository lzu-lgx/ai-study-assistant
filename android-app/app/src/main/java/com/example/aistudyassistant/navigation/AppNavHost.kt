package com.example.aistudyassistant.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aistudyassistant.ui.screen.HomeScreen
import com.example.aistudyassistant.ui.screen.KnowledgeBaseScreen
import com.example.aistudyassistant.ui.screen.ChatScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = modifier
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onStartClick = {
                    navController.navigate(Routes.KNOWLEDGE_BASE)
                }
            )
        }

        composable(Routes.KNOWLEDGE_BASE) {
            KnowledgeBaseScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onKnowledgeBaseClick = {
                    navController.navigate(Routes.CHAT)
                }
            )
        }

        composable(Routes.CHAT) {
            ChatScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

