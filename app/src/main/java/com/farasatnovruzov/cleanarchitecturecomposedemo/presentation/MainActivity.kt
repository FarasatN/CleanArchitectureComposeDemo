package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid.ImdbByIdToFun
import com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname.ImdbByNameToFun
import com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.ui.theme.CleanArchitectureComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContent {
//            runBlocking {
//                val loggingInterceptor = HttpLoggingInterceptor().apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                }
//                val okHttpClient = OkHttpClient.Builder()
//                    .addInterceptor(loggingInterceptor)
//                    .build()
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .client(okHttpClient)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                val imdbApi = retrofit.create(ImdbAPI::class.java)
//                // Test getImdbByName
//                try {
//                    println("--- Testing getImdbByName ---")
//                    val nameResponse = imdbApi.getImdbByName(query = "inception")
//                    if (nameResponse.success) {
//                        nameResponse.result?.forEach {
//                            println("Title: "+it.Title)
//                            println("imdbID: "+it.imdbID)
//                            println("Type: "+it.Type)
//                            println("Year: "+it.Year)
//                            println("Poster: "+it.Poster)
//                        }
//                    } else {
//                        println("Error: getImdbByName was not successful")
//                    }
//                } catch (e: Exception) {
//                    println("Error during getImdbByName: ${e.message}")
//                }
//
//                // Test getImdbById
//                try {
//                    println("\n--- Testing getImdbById ---")
//                    val idResponse =
//                        imdbApi.getImdbById(query = "tt1375666") // IMDb ID for Inception
//                    if (idResponse.success) {
//                        println("Title: "+idResponse.result.Title)
//                        println("imdbID: "+idResponse.result.imdbID)
//                        println("Type: "+idResponse.result.Type)
//                        println("Year: "+idResponse.result.Year)
//                        println("Poster: "+idResponse.result.Poster)
//                        println("Ratings: "+idResponse.result.Ratings)
//                        println("Plot: "+idResponse.result.Plot)
//                        println("Genre: "+idResponse.result.Genre)
//                        println("Director: "+idResponse.result.Director)
//                        println("Actors: "+idResponse.result.Actors)
//                        println("Writer: "+idResponse.result.Writer)
//                        println("Language: "+idResponse.result.Language)
//                        println("Country: "+idResponse.result.Country)
//                        println("Awards: "+idResponse.result.Awards)
//                        println("Metascore: "+idResponse.result.Metascore)
//                        println("imdbRating: "+idResponse.result.imdbRating)
//                        println("imdbVotes: "+idResponse.result.imdbVotes)
//                        println("DVD: "+idResponse.result.DVD)
//                        println("BoxOffice: "+idResponse.result.BoxOffice)
//                        println("Production: "+idResponse.result.Production)
//                        println("Website: "+idResponse.result.Website)
//                        println("Response: "+idResponse.result.Response)
//                        println("Rated: "+idResponse.result.Rated)
//                        println("Released: "+idResponse.result.Released)
//                        println("Runtime: "+idResponse.result.Runtime)
//                        println("imdbVotes: "+idResponse.result.imdbVotes)
//
//                    } else {
//                        println("Error: getImdbById was not successful")
//                    }
//                } catch (e: Exception) {
//                    println("Error during getImdbById: ${e.message}")
//                }
//            }
//        }

        //-------------------------------------

        setContent {
            CleanArchitectureComposeDemoTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("IMDb Search") },
                            navigationIcon = {
                                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                                if (currentBackStackEntry?.destination?.route != Screen.ImdbByName.route) {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                                    }
                                }
                            },
                            actions = {
                                IconButton(onClick = { navController.navigate(Screen.ImdbById.route) }) {
                                    Icon(
                                        Icons.Filled.ArrowForward,
                                        contentDescription = "Go to IMDb by ID"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ImdbByName.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.ImdbByName.route) {
                            ImdbByNameToFun(navController)
                        }
                        composable(Screen.ImdbById.route) {
                            ImdbByIdToFun(navController)
                        }
                    }
                }
            }
        }
    }
}