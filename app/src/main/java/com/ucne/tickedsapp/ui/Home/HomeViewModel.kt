package com.ucne.tickedsapp.ui.Home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.tickedsapp.data.dto.TicketDto
import com.ucne.tickedsapp.data.repository.TicketRepository
import com.ucne.tickedsapp.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class TicketListUiState(
    val ticket: List<TicketDto> = emptyList(),
    val isLoading : Boolean = false,
    val error : String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: TicketRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(TicketListUiState())
    val uiState: StateFlow<TicketListUiState> = _uiState.asStateFlow()

    init {
        repository.getListTickts().onEach { result ->
            when(result) {
                is Resources.Loading -> {
                    _uiState.value = TicketListUiState(isLoading = true)
                }
                is Resources.Success -> {
                    _uiState.value = TicketListUiState(ticket = result.data ?: emptyList())
                }
                is Resources.Error -> {
                    _uiState.value = TicketListUiState(error = result.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}