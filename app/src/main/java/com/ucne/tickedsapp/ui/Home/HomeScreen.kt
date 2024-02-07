package com.ucne.tickedsapp.ui.Home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ucne.tickedsapp.data.dto.TicketDto

import com.ucne.tickedsapp.ui.theme.TickedsAppTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    registroNavigation: () -> Unit,
    onClickSeleccionado: (Int) -> Unit
) {
    TickedsAppTheme{

        val uiState by viewModel.uiState.collectAsState()
        Base(uiState.ticket, registroNavigation)
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Base(ticketDto: List<TicketDto>, registroNavigation: () -> Unit) {
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
                actions = {
                    IconButton(onClick = registroNavigation) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Añadir un nuevo registro"
                        )
                    }
                }
            )

        }

    ){
        ComboBox()
    }
}
@Composable
private fun ComboBox(){
    var expandido by remember { mutableStateOf(false) }

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

            val ocupaciones = listOf("Bombero", "Ingeniero", "Médico", "Policia", "Militar")
            var ocupacionSeleccionada by remember { mutableStateOf("") }


            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = ocupacionSeleccionada,
                    onValueChange = { ocupacionSeleccionada = it },
                    readOnly = true,
                    enabled = false,
                    label = { Text(text = "Ocupación") },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                    },
                    modifier = Modifier
                        .clickable {
                            expandido = true
                            Log.e("tag", "expandido")
                        }
                        .fillMaxWidth()
                )
                DropdownMenu(
                    expanded = expandido,
                    onDismissRequest = { expandido = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ocupaciones.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                expandido = false
                                ocupacionSeleccionada = item
                            })

                    }
                }
            }

            // Mostrar el Card con los datos de la persona seleccionada
            if (ocupacionSeleccionada.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Detalles de la persona seleccionada",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 0.dp, 0.dp, 16.dp)
                        )

                        Text(text = "Ocupación: $ocupacionSeleccionada")

                    }
                }
            }
        }
    }
}

