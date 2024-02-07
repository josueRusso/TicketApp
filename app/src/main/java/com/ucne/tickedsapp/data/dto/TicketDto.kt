package com.ucne.tickedsapp.data.dto

data class TicketDto(
    val idTicket: Int,
    val fecha: String,
    val vence: String,
    val idCliente: Int,
    val empresa: String,
    val solicitadoPor: String,
    val asunto: String,
    val prioridad: Int,
)
