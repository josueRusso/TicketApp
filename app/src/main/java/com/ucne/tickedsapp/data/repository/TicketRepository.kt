package com.ucne.tickedsapp.data.repository

import android.util.Log
import com.ucne.tickedsapp.data.TicketApi
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


class TicketRepository @Inject constructor(
    private val ticket : TicketApi
) {
    //lista de ticket
    fun getListTickts(): Flow<Resources<List<TicketDto>>> = flow {
        try {
            emit(Resources.Loading())
            emit(Resources.Success(ticket.GetList()))
        } catch (e: IOException) {
            emit(Resources.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    //buscar ticket por id
    suspend fun getTicket(id: Int): TicketDto {
        try {
            return ticket.GetTicket(id)
        } catch (e: Exception) {
            throw e
        }
    }

    //guardar ticket
    suspend fun postTicket(ticketsDto: TicketDto): Response<TicketDto> {
        try {
            return ticket.postTicket(ticketsDto)
        } catch (e: Exception) {
            Log.i("Ticket", e.message!!)
            throw e
        }
    }

    //modificar ticket
    suspend fun updateTickets(id: Int, newTicket: TicketDto): Response<TicketDto> {
        try {
            return ticket.PutTicket(id, newTicket)
        } catch (e: Exception) {
            throw e
        }
    }

    //eliminar ticket
    suspend fun deleteTickets(id: Int): Response<TicketDto> {
        try {
            return ticket.deleteTicket(id)
        } catch (e: Exception) {
            throw e
        }
    }

}
