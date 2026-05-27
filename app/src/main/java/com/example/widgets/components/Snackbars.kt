package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackbarShowcase() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Snackbars", style = MaterialTheme.typography.titleLarge)

            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("This is a simple snackbar")
                }
            }) {
                Text("Show Snackbar")
            }

            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Snackbar with action",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text("Show Snackbar with Action")
            }
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}
