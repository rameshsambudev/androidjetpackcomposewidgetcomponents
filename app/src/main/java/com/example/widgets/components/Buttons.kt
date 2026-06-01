package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EZPrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun EZSecondaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun EZTertiaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    TextButton(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun EZIconButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
    }
}

@Composable
fun EZFloatingActionButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Filled.Favorite, contentDescription = "Add")
    }
}

@Composable
fun EZButtonsShowcase() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Buttons", style = MaterialTheme.typography.titleLarge)
        EZPrimaryButton(text = "Primary Button", onClick = {})
        EZSecondaryButton(text = "Outlined Button", onClick = {})
        EZTertiaryButton(text = "Text Button", onClick = {})
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            EZIconButton(onClick = {})
            EZFloatingActionButton(onClick = {})
        }
    }
}
