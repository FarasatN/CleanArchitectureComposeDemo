package com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto

import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbById


data class ImdbByIdDto(
    val result: ResultById?,
    val success: Boolean
)

fun ImdbByIdDto.toImdbById(): ImdbById {
    return ImdbById(
        Actors = result?.Actors,
            Awards = result?.Awards,
            BoxOffice = result?.BoxOffice,
            Country = result?.Country,
            Plot = result?.Plot,
            Poster = result?.Poster,
            Production = result?.Production,
            Rated = result?.Rated,
            Ratings = result?.Ratings,
            Released = result?.Released,
            Response = result?.Response,
            Runtime = result?.Runtime,
            Title = result?.Title,
            Type = result?.Type,
            Website = result?.Website,
            Writer = result?.Writer,
            Year = result?.Year,
            imdbID = result?.imdbID,
            imdbRating = result?.imdbRating,
            imdbVotes = result?.imdbVotes,
            Director = result?.Director,
            Genre = result?.Genre,
            Language = result?.Language,
            Metascore = result?.Metascore,
            DVD = result?.DVD,
    )
}

//fun ImdbByIdDto.toImdbById(): ImdbById {
//    return result?.let { result ->
//        ImdbById(
//            Actors = result?.Actors,
//            Awards = result?.Awards,
//            BoxOffice = result?.BoxOffice,
//            Country = result?.Country,
//            Plot = result?.Plot,
//            Poster = result?.Poster,
//            Production = result?.Production,
//            Rated = result?.Rated,
//            Ratings = result?.Ratings,
//            Released = result?.Released,
//            Response = result?.Response,
//            Runtime = result?.Runtime,
//            Title = result?.Title,
//            Type = result?.Type,
//            Website = result?.Website,
//            Writer = result?.Writer,
//            Year = result?.Year,
//            imdbID = result?.imdbID,
//            imdbRating = result?.imdbRating,
//            imdbVotes = result?.imdbVotes,
//            Director = result?.Director,
//            Genre = result?.Genre,
//            Language = result?.Language,
//            Metascore = result?.Metascore,
//            DVD = result.DVD,
//        )
//    } ?: throw Exception("No results found")
//}