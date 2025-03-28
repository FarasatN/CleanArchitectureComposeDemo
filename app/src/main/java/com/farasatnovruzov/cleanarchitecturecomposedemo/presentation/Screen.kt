package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation

sealed class Screen(val route: String) {
    object ImdbByName : Screen("imdb_by_name")
    object ImdbById : Screen("imdb_by_id")
}
