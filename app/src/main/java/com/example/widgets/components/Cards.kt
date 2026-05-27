package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicCard(title: String, description: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun ElevatedCardComponent(title: String, description: String, modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun OutlinedCardComponent(title: String, description: String, modifier: Modifier = Modifier) {
    OutlinedCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun CardsShowcase() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Cards", style = MaterialTheme.typography.titleLarge)
        BasicCard(title = "Basic Card", description = "This is a basic filled card.")
        ElevatedCardComponent(title = "Elevated Card", description = "This card has elevation.")
        OutlinedCardComponent(title = "Outlined Card", description = "This card has an outline border.")
    }
}
