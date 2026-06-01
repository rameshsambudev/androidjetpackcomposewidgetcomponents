package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZFilterChip(label: String, selected: Boolean, onSelected: (Boolean) -> Unit) {
    FilterChip(
        selected = selected,
        onClick = { onSelected(!selected) },
        label = { Text(label) },
        leadingIcon = if (selected) {
            { Icon(Icons.Filled.Check, contentDescription = null) }
        } else null
    )
}

@Composable
fun EZInputChip(label: String, onDismiss: () -> Unit) {
    InputChip(
        selected = false,
        onClick = {},
        label = { Text(label) },
        trailingIcon = {
            IconButton(onClick = onDismiss, modifier = Modifier.size(18.dp)) {
                Icon(Icons.Filled.Close, contentDescription = "Remove")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZChipsShowcase() {
    var filter1 by remember { mutableStateOf(false) }
    var filter2 by remember { mutableStateOf(true) }
    var filter3 by remember { mutableStateOf(false) }
    var chips by remember { mutableStateOf(listOf("Kotlin", "Compose", "Android")) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Chips", style = MaterialTheme.typography.titleLarge)

        Text("Filter Chips", style = MaterialTheme.typography.titleSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EZFilterChip("Option 1", filter1) { filter1 = it }
            EZFilterChip("Option 2", filter2) { filter2 = it }
            EZFilterChip("Option 3", filter3) { filter3 = it }
        }

        Text("Input Chips", style = MaterialTheme.typography.titleSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            chips.forEach { chip ->
                EZInputChip(label = chip, onDismiss = { chips = chips - chip })
            }
        }
    }
}
