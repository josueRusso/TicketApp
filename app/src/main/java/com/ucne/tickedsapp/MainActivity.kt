package com.ucne.tickedsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.ui.Home.HomeScreen
import com.ucne.tickedsapp.ui.Navegacion.Screen
import com.ucne.tickedsapp.ui.RegistroTicket.RegistroTicketScreen
import com.ucne.tickedsapp.ui.SeleccionTicket.SeleccionTicketScreen
import com.ucne.tickedsapp.ui.theme.TickedsAppTheme
import kotlinx.coroutines.channels.ticker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TickedsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val navController = rememberNavController()
                    Menu(navController = navController)

                }
            }
        }
    }
}

@Composable
private fun Menu(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                registroNavigation = { navController.navigate(Screen.RegistroTicket.route) }
            ){
                navController.navigate(Screen.SeleccionTicket.route + "/$it")
            }
        }

        composable(
            Screen.SeleccionTicket.route + "/{id}",
            arguments = listOf(navArgument("id") {type = NavType.IntType})
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            SeleccionTicketScreen(
                id = id
            )
        }

        composable(Screen.RegistroTicket.route) {
            RegistroTicketScreen()
        }
    }
}