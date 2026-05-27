package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun SecondaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun TertiaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    TextButton(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun IconButtonComponent(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
    }
}

@Composable
fun FloatingActionButtonComponent(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Filled.Favorite, contentDescription = "Add")
    }
}

@Composable
fun ButtonsShowcase() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Buttons", style = MaterialTheme.typography.titleLarge)
        PrimaryButton(text = "Primary Button", onClick = {})
        SecondaryButton(text = "Outlined Button", onClick = {})
        TertiaryButton(text = "Text Button", onClick = {})
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            IconButtonComponent(onClick = {})
            FloatingActionButtonComponent(onClick = {})
        }
    }
}
