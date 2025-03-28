package com.farasatnovruzov.cleanarchitecturecomposedemo.presentation.imdbbyname.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model.ImdbByName
import kotlinx.coroutines.launch

@Composable
fun ImdbByNameItem(imdbByName: ImdbByName) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    SelectionContainer {

        Row(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.DarkGray)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = imdbByName.Title!!, modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        clipboardManager.setText(AnnotatedString(imdbByName.Title!!))
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "Text copied to clipboard",
                                actionLabel = "Dismiss"
                            )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    /* Handle snackbar action if needed */
                                }

                                SnackbarResult.Dismissed -> {
                                    /* Handle snackbar dismissal if needed */
                                }
                            }
                        }
                    })
                }, fontSize = 10.sp, fontStyle = FontStyle.Normal
            )
            Text(text = imdbByName.Year!!, modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        clipboardManager.setText(AnnotatedString(imdbByName.Year!!))
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "Text copied to clipboard",
                                actionLabel = "Dismiss"
                            )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    /* Handle snackbar action if needed */
                                }

                                SnackbarResult.Dismissed -> {
                                    /* Handle snackbar dismissal if needed */
                                }
                            }
                        }
                    })
                }, fontSize = 10.sp, fontStyle = FontStyle.Normal
            )
            Text(text = imdbByName.imdbID!!, modifier = Modifier
                .padding(16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = {
                        clipboardManager.setText(AnnotatedString(imdbByName.imdbID!!))
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "Text copied to clipboard",
                                actionLabel = "Dismiss"
                            )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    /* Handle snackbar action if needed */
                                }

                                SnackbarResult.Dismissed -> {
                                    /* Handle snackbar dismissal if needed */
                                }
                            }
                        }
                    })
                }, fontSize = 10.sp, fontStyle = FontStyle.Normal
            )
//        Text(text = imdbByName.Poster, fontSize = 16.sp, fontStyle = FontStyle.Normal)
        }
    }
}