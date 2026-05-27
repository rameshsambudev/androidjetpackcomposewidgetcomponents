package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SwitchComponent(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
fun CheckboxComponent(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(label)
    }
}

@Composable
fun RadioButtonGroupComponent(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { onOptionSelected(option) }
                )
                Text(option)
            }
        }
    }
}

@Composable
fun SwitchesShowcase() {
    var switch1 by remember { mutableStateOf(true) }
    var switch2 by remember { mutableStateOf(false) }
    var check1 by remember { mutableStateOf(true) }
    var check2 by remember { mutableStateOf(false) }
    var selectedRadio by remember { mutableStateOf("Option A") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Switches & Selection", style = MaterialTheme.typography.titleLarge)

        Text("Switches", style = MaterialTheme.typography.titleSmall)
        SwitchComponent("Wi-Fi", switch1) { switch1 = it }
        SwitchComponent("Bluetooth", switch2) { switch2 = it }

        Text("Checkboxes", style = MaterialTheme.typography.titleSmall)
        CheckboxComponent("Accept Terms", check1) { check1 = it }
        CheckboxComponent("Subscribe to Newsletter", check2) { check2 = it }

        Text("Radio Buttons", style = MaterialTheme.typography.titleSmall)
        RadioButtonGroupComponent(
            options = listOf("Option A", "Option B", "Option C"),
            selectedOption = selectedRadio,
            onOptionSelected = { selectedRadio = it }
        )
    }
}
