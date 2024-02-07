package com.ucne.tickedsapp.data.dto

data class TicketDto(
    val idTicket: Int = 0,
    val fecha: String,
    val vence: String,
    val idCliente: Int,
    val empresa: String,
    val solicitadoPor: String,
    val asunto: String,
    val prioridad: Int,
)
