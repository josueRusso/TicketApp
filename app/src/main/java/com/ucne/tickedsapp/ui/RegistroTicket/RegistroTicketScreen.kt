package com.ucne.tickedsapp.ui.RegistroTicket

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.ui.theme.TickedsAppTheme


@Composable
fun RegistroTicketScreen(
    //ticketId: Int,
    //onPressCancel: () -> Unit,
    //viewModel: TicketViewModel = hiltViewModel()
) {

    Base()
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Base() {
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
        RegistroTicket()
    }
}
@Composable
private fun RegistroTicket() {
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var Fecha by remember { mutableStateOf("") }
    var solicitadoPor by remember { mutableStateOf("") }
    var asunto by remember { mutableStateOf("") }
    var prioridad by remember { mutableStateOf("") }

    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro de personas",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text(text = "Ticket Id") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text(text = "Fecha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                label = { Text(text = "Vence") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Cliente Id") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = Fecha,
                onValueChange = { Fecha = it },
                label = { Text(text = "Empresa") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = solicitadoPor,
                onValueChange = { solicitadoPor = it },
                label = { Text(text = "solicitado Por") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = asunto,
                onValueChange = { asunto = it },
                label = { Text(text = "Asunto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            OutlinedTextField(
                value = prioridad,
                onValueChange = { prioridad = it },
                label = { Text(text = "Prioridad") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Acción para el botón "Eliminar"
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Eliminar")
                        Spacer(modifier = Modifier.width(4.dp))

                    }
                }

                Button(
                    onClick = {
                        // Acción para el botón "Guardar"
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                        Spacer(modifier = Modifier.width(4.dp))

                    }
                }

                Button(
                    onClick = {
                        // Acción para el botón "Buscar"
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Nuevo")
                        Spacer(modifier = Modifier.width(4.dp))

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    TickedsAppTheme {
        Base()
    }
}