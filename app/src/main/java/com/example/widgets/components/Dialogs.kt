package com.example.widgets.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicAlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    title: String,
    message: String
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(title) },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = onConfirm) { Text("Confirm") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) { Text("Cancel") }
            }
        )
    }
}

@Composable
fun DialogsShowcase() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Dialogs", style = MaterialTheme.typography.titleLarge)
        Button(onClick = { showDialog = true }) {
            Text("Show Alert Dialog")
        }
        BasicAlertDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            onConfirm = { showDialog = false },
            title = "Confirm Action",
            message = "Are you sure you want to proceed with this action?"
        )
    }
}
