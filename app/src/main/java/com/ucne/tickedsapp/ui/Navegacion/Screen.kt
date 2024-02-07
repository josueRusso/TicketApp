package com.ucne.tickedsapp.ui.Navegacion

sealed class Screen (val route: String){
    object Home: Screen("Home")
    object RegistroTicket: Screen("RegistroTicket")
    object SeleccionTicket: Screen("SeleccionTicket")

}