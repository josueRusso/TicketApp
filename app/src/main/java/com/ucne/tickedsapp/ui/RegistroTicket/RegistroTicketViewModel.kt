package com.ucne.tickedsapp.ui.RegistroTicket

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.data.repository.TicketRepository
import com.ucne.tickedsapp.ui.SeleccionTicket.TicketUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


@HiltViewModel
class TicketViewModel @Inject constructor(

    private val ticketsRepository: TicketRepository
) : ViewModel() {

    var ticketsUiState = MutableStateFlow(TicketUiState())
        private set

    @RequiresApi(Build.VERSION_CODES.O)
    fun save() {
        viewModelScope.launch {
            if (ticketsUiState.value.ticket.idTicket > 0) {
                val lastTicket = ticketsRepository.getTicket(ticketsUiState.value.ticket.idTicket)
                if(lastTicket!=null) {
                    ticketsRepository.updateTickets(
                        lastTicket.idTicket,
                        TicketDto(
                            idTicket = lastTicket.idTicket,
                            fecha = LocalDate.now().toString(),
                            vence = LocalDate.now().toString(),
                             idCliente = ticketsUiState.value.ticket.idCliente,
                            empresa = ticketsUiState.value.ticket.empresa,
                            solicitadoPor = ticketsUiState.value.ticket.solicitadoPor,
                            asunto = ticketsUiState.value.ticket.asunto,
                            prioridad = ticketsUiState.value.ticket.prioridad,

                        )
                    )
                }
            } else {
                ticketsRepository.postTicket(
                    TicketDto(
                        idTicket = 0,
                        fecha = LocalDate.now().toString(),
                        vence = LocalDate.now().toString(),
                        idCliente = ticketsUiState.value.ticket.idCliente,
                        empresa = ticketsUiState.value.ticket.empresa,
                        solicitadoPor = ticketsUiState.value.ticket.solicitadoPor,
                        asunto = ticketsUiState.value.ticket.asunto,
                        prioridad = ticketsUiState.value.ticket.prioridad,
                    )
                )
            }
            clean()
        }

    }

    fun clean() {
        ticketsUiState.value.ticket = ticketsUiState.value.ticket.copy(

            idTicket = 0,
            fecha = "",
            vence = "",
            idCliente = 0,
            empresa = "",
            solicitadoPor = "",
            asunto = "",
            prioridad = 0,
        )
    }
    fun find(ticketId: Int) {
        if (ticketId > 0) {
            viewModelScope.launch {
                val ticketEncontrado = ticketsRepository.getTicket(ticketId)
                if (ticketEncontrado != null) {
                    ticketsUiState.value.ticket = ticketsUiState.value.ticket.copy(
                        idTicket = ticketEncontrado.idTicket,
                        fecha = ticketEncontrado.fecha,
                        vence = ticketEncontrado.vence,
                        idCliente = ticketEncontrado.idCliente,
                        empresa = ticketEncontrado.empresa,
                        solicitadoPor = ticketEncontrado.solicitadoPor,
                        asunto = ticketEncontrado.asunto,
                        prioridad = ticketEncontrado.prioridad
                    )

                }

            }
        }
    }

    fun delete(ticketId: Int) {
        viewModelScope.launch {
            val result = ticketsRepository.deleteTickets(ticketId)
            if (result.isSuccessful) {

            } else {

            }
        }
   }
}