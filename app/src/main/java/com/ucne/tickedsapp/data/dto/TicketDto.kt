package com.ucne.tickedsapp.data.dto

data class TicketDto(
    val idTicket: Int,
    val idCliente: Int,
    val idSistema: Int,
    val idTipo: Int,
    val prioridad: Int,
    val solicitadopPor: String,
    val asunto: String,
    val especificaciones: String,
)
