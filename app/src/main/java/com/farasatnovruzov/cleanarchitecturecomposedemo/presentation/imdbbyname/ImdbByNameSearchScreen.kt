package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname.components.ImdbByNameItem

@Composable
fun ImdbByNameToFun(
    navController: NavController,
    imdbByNameViewModel: ImdbByNameViewModel = hiltViewModel()
) {
    val state = imdbByNameViewModel.imdbByNameState.value
    var searchImdbText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchImdbText,
            onValueChange = { searchImdbText = it },
            label = { Text("Enter IMDb name (e.g., Inception)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { imdbByNameViewModel.searchMovieByName(searchImdbText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            state.error.isNotBlank() -> Text(
                text = state.error,
                modifier = Modifier.fillMaxWidth()
            )
            state.imdbByName != null && state.imdbByName.isNotEmpty() -> {
                LazyColumn {
                    items(state.imdbByName) { imdbByName ->
                        ImdbByNameItem(imdbByName)
                        Divider()
                    }
                }
            }
            else -> Text(
                text = "Enter a search term to begin...",
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
