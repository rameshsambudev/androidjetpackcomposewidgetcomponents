package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuComponent(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    label: String = "Select"
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor().fillMaxWidth()
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun DropdownsShowcase() {
    var selected by remember { mutableStateOf("Kotlin") }
    val languages = listOf("Kotlin", "Java", "Swift", "Dart", "TypeScript")

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Dropdowns", style = MaterialTheme.typography.titleLarge)
        DropdownMenuComponent(
            options = languages,
            selectedOption = selected,
            onOptionSelected = { selected = it },
            label = "Language"
        )
    }
}
