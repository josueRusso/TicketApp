package com.ucne.tickedsapp.ui.SeleccionTicket

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.data.repository.TicketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



data class TicketUiState(
    var ticket: TicketDto = TicketDto(
        0,
        "",
        "",
        0,
        "",
        "",
        "",
        0,
    )
)


@HiltViewModel
class SeleccionTicketViewModel @Inject constructor(
    val repository: TicketRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TicketUiState())
    val uiState: StateFlow<TicketUiState> = _uiState.asStateFlow()

    var id by mutableStateOf(0)

    fun getById(id: Int) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(ticket = repository.getTicket(id))
            }
        }
    }

}