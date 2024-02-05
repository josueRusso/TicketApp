package com.ucne.tickedsapp.data

import com.ucne.tickedsapp.data.dto.TicketDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TicketApi{
    @GET("Gastos")
    @Headers("X-API-key: test")
    suspend fun GetList(): List<TicketDto>

    @GET("Gastos/{id}")
    @Headers("X-API-key: test")
    suspend fun GetTicket(@Path("id") id: Int): TicketDto
}