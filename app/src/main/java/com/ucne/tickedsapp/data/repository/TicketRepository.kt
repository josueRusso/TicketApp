package com.ucne.tickedsapp.data.repository

import com.ucne.tickedsapp.data.TicketApi
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class TicketRepository @Inject constructor(
    private val ticket : TicketApi
) {
    fun getListTicket(): Flow<Resources<List<TicketDto>>> = flow {
        try {
            emit(Resources.Loading())
            emit(Resources.Success(ticket.GetList()))
        } catch (e: IOException) {
            emit(Resources.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun getTicket(id: Int): TicketDto {
        try {
            return ticket.GetTicket(id)
        } catch (e: Exception) {
            throw e
        }
    }

}
