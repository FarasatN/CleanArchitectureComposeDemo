package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyid.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbById

@Composable
fun ImdbByIdItem(imdbById: ImdbById) {
//    SelectionContainer {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Title!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Year!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Type!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.imdbRating!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.imdbID!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.imdbVotes!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Actors!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Awards!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.BoxOffice!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Country!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.DVD!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Director!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Genre!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Language!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Metascore!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Plot!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Poster!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Production!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Released!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Response!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Runtime!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = imdbById.Website!!, fontSize = 10.sp, fontStyle = FontStyle.Normal)
        }

//    }
}