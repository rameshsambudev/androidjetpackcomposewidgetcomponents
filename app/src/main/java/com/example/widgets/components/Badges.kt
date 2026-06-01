package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EZBadgedIcon(count: Int, icon: @Composable () -> Unit) {
    BadgedBox(badge = { Badge { Text("$count") } }) {
        icon()
    }
}

@Composable
fun EZBadgesShowcase() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Badges", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            EZBadgedIcon(count = 5) {
                Icon(Icons.Filled.Email, contentDescription = "Email")
            }
            EZBadgedIcon(count = 12) {
                Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
            }
        }
    }
}
