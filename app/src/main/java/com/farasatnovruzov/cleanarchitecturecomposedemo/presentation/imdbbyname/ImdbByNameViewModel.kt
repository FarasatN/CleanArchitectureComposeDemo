package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.usecase.imdbbyname.ImdbByNameUseCase
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImdbByNameViewModel @Inject constructor(private val imdbByNameUseCase: ImdbByNameUseCase) :
    ViewModel() {
    private val _imdbByNameState = mutableStateOf(ImdbByNameState())
    val imdbByNameState: State<ImdbByNameState> = _imdbByNameState

//    init {
//        getImdbByName()
//    }

    private var job: Job? = null
    // Function to trigger the movie search when the button is clicked
    fun searchMovieByName(query: String) { // Takes the query as a parameter
        if (query.isNotBlank()) {
            getImdbByName(query)
        } else {
            _imdbByNameState.value = _imdbByNameState.value.copy(error = "Please enter an IMDb name.")
        }
    }
    private fun getImdbByName(query: String) {
        job?.cancel()
        job = imdbByNameUseCase.getImdbByName(query).onEach {
            when (it) {
                is Resource.Success -> {
                    _imdbByNameState.value = _imdbByNameState.value.copy(
                        isLoading = false,
                        imdbByName = it.data ?: emptyList(),
                    )
//                   ImdbByNameState(imdbByName = it.data ?: emptyList())
                    println(it.data)
                }
                is Resource.Error -> {
                    _imdbByNameState.value = _imdbByNameState.value.copy(
                        isLoading = false,
                        error = it.message ?: "An unexpected error occurred",
                    )
                }
                is Resource.Loading -> {
                    _imdbByNameState.value = _imdbByNameState.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}