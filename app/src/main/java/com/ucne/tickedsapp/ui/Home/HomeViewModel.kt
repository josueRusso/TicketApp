package com.ucne.tickedsapp.ui.Home

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


data class TicketListUiState(
    val ticket: List<TicketDto> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: TicketRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(TicketListUiState())
    val uiState: StateFlow<TicketListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(ticket = repository.getTickets())
            }
        }
    }
}