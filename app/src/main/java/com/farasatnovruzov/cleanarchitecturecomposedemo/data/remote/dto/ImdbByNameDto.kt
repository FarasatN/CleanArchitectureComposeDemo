package com.farasatnovruzov.cleanarchitecturecomposedemo.data.remote.dto

import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbByName
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

data class ImdbByNameDto(
//    val result: Any?,
    val result: List<ImdbByName>?,
    val success: Boolean
)

class ImdbByNameDtoDeserializer : JsonDeserializer<ImdbByNameDto> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ImdbByNameDto {
        val jsonObject = json.asJsonObject
        val success = jsonObject.get("success").asBoolean

        val resultElement = jsonObject.get("result")
        val resultList: List<ImdbByName> = when {
            resultElement.isJsonArray -> {
                // Deserialize the array to a list of ImdbByName objects
                context.deserialize(resultElement, object : TypeToken<List<ImdbByName>>() {}.type)
            }

            resultElement.isJsonPrimitive && resultElement.asJsonPrimitive.isString -> {
                // Handle the error message if result is a string
                println("Error from API: ${resultElement.asString}")
                emptyList()
            }

            else -> {
                println("Unexpected result type: ${resultElement.javaClass.name}")
                emptyList()
            }
        }

        return ImdbByNameDto(result = resultList, success = success)
    }
}


//fun ImdbByNameDto.toImdbByName(): List<ImdbByName> {
//    return when (val actualResult = result) {
//        null -> {
//            println("Result is null")
//            emptyList()
//        }
//        is List<*> -> {
//            // Assuming each item is already an ImdbByName or needs to be cast.
//            actualResult.filterIsInstance<ImdbByName>()
//        }
//        is String -> {
//            // Handle the error message from the API
//            println("Error from API: $actualResult")
//            emptyList()
//        }
//        else -> {
//            println("Unexpected type: ${actualResult::class.java.name}")
//            emptyList()
//        }
//    }
//}



//fun ImdbByNameDto.toImdbByName(): List<ImdbByName> {
//    return result?.map { itemDto ->
//        ImdbByName(
//            Poster = itemDto.Poster.orEmpty(),
//            Title = itemDto.title.orEmpty(),  // Use DTO field name
//            Type = itemDto.Type.orEmpty(),
//            Year = itemDto.Year.orEmpty(),
//            imdbID = itemDto.imdbId.orEmpty()
//        )
//    } ?: emptyList()
//}

//fun ImdbByNameDto.toImdbByName(): List<ImdbByName> {
//    return when {
//        success && result is List<*> -> {
//            (result as List<ImdbByName>).map { item ->
//                ImdbByName(
//                    Poster = item.Poster.orEmpty(),
//                    Title = item.Title.orEmpty(),
//                    Type = item.Type.orEmpty(),
//                    Year = item.Year.orEmpty(),
//                    imdbID = item.imdbID.orEmpty()
//                )
//            }
//        }
//        result is String -> {
//            println("API Error: $result")
//            emptyList()
//        }
//        else -> {
//            println("Unexpected response type")
//            emptyList()
//        }
//    }
//}