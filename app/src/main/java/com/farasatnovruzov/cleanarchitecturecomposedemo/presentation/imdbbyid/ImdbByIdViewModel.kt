package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.usecase.imdbbyid.ImdbByIdUseCase
import com.farasatnovruzov.cleanarchitecturecomposedemo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImdbByIdViewModel @Inject constructor(private val imdbByIdUseCase: ImdbByIdUseCase) :
    ViewModel() {
    private val _imdbByIdState = mutableStateOf(ImdbByIdState())
    val imdbByIdState: State<ImdbByIdState> = _imdbByIdState
//    var searchQuery = mutableStateOf("")
//    init {
//        getImdbById(searchQuery.value)
//    }

    private var job: Job? = null
    // Function to trigger the movie search when the button is clicked
    fun searchMovieById(movieId: String) { // Takes the query as a parameter
        if (movieId.isNotBlank()) {
            getImdbById(movieId)
        } else {
            _imdbByIdState.value = _imdbByIdState.value.copy(error = "Please enter an IMDb ID.")
        }
    }
    private fun getImdbById(searchQuery: String) {
        job?.cancel()
        job = imdbByIdUseCase.getImdbById(searchQuery).onEach {
            when (it) {
                is Resource.Success -> {
                    _imdbByIdState.value = _imdbByIdState.value.copy(
                        isLoading = false,
                        imdbById = it.data
                    )
                }
                is Resource.Error -> {
                    _imdbByIdState.value = _imdbByIdState.value.copy(
                        isLoading = false,
                        error = it.message ?: "An unexpected error occurred",
                    )
                }
                is Resource.Loading -> {
                    _imdbByIdState.value = _imdbByIdState.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}