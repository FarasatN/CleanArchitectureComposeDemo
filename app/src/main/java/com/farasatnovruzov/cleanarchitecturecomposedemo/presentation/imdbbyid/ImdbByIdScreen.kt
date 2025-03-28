package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid.components.ImdbByIdItem

@Composable
fun ImdbByIdToFun(
    navController: NavController,
    imdbByIdViewModel: ImdbByIdViewModel = hiltViewModel()
) {
    val state = imdbByIdViewModel.imdbByIdState.value
    var searchImdbText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchImdbText,
            onValueChange = { searchImdbText = it },
            label = { Text("Enter IMDb ID (e.g., tt0050083)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { imdbByIdViewModel.searchMovieById(searchImdbText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            state.error.isNotBlank() -> Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth()
            )
            state.imdbById != null -> {
                ImdbByIdItem(state.imdbById)
            }
            else -> Text(
                text = "Enter an IMDb ID to begin...",
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
