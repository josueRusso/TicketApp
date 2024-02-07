package com.ucne.tickedsapp.ui.SeleccionTicket

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.ui.theme.TickedsAppTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun SeleccionTicketScreen(
    id: Int = 0,
    viewModel: SeleccionTicketViewModel = hiltViewModel(),


) {
    remember {
        viewModel.getById(id)
        0
    }

    val uiState by viewModel.uiState.collectAsState()
    Base(uiState.ticket)
}

@Composable
private fun Contenido(ticket : TicketDto){

    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "IdTicket: " + ticket.idTicket.toString(),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.padding(0.dp,10.dp))

                Text(
                    text = "Fecha: " + ticket.fecha,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.padding(0.dp,10.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "IdCliente: " + ticket.idCliente.toString(),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.padding(0.dp,10.dp))

                Text(
                    text = "Vence: " + ticket.vence.toString(),
                    fontSize = 20.sp
                )

            }

            Spacer(modifier = Modifier.padding(0.dp,10.dp))

            Text(
                text = "Empresa: " + ticket.empresa.toString(),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(0.dp,10.dp))

            Text(
                text = "Solicitado Por: " + ticket.solicitadoPor,
                fontSize = 19.sp
            )

            Spacer(modifier = Modifier.padding(0.dp,10.dp))

            Text(
                text = "Asunto: " + ticket.asunto,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(0.dp,10.dp))

            Text(
                text = "Prioridad: " + ticket.prioridad.toString(),
                fontSize = 19.sp
            )

            Spacer(modifier = Modifier.padding(0.dp,10.dp))
            

                


        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
 private fun Base(ticket : TicketDto) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF8BDBF3)),
                title = {
                    Text(
                        "TicketApp",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },

            )
        }

    ){
        Contenido(ticket = ticket)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TickedsAppTheme {
        val ticket = TicketDto(
            1,
            "2024-5-2",
            "2024-5-3",
            1,
            "Sanchez",
            "Rodriguez Hernadez",
            "Empresa",
            1,
        )
        Base(ticket)
    }
}


