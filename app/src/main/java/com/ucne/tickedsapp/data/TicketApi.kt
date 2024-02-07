package com.ucne.tickedsapp.data

import com.ucne.tickedsapp.data.dto.TicketDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TicketApi{
    @GET("/api/Tickets")
    @Headers("X-API-key: test")
    suspend fun GetList(): List<TicketDto>

    @GET("/api/Tickets/{id}")
    @Headers("X-API-key: test")
    suspend fun GetTicket(@Path("id") id: Int): TicketDto

    @PUT("/api/Tickets/{id}")
    @Headers("X-API-key: test")
    suspend fun PutTicket(@Path("id") id: Int, @Body ticketDto: TicketDto): Response<TicketDto>

    @POST("/api/Tickets")
    @Headers("X-API-key: test")
    suspend fun postTicket(@Body ticketDto: TicketDto ) : Response<TicketDto>

    @DELETE("/api/Tickets/{id}")
    @Headers("X-API-key: test")
    suspend fun deleteTicket(@Path("id") id: Int): Response<TicketDto>

}