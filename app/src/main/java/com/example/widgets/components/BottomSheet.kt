package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZBottomSheetShowcase() {
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Bottom Sheet", style = MaterialTheme.typography.titleLarge)
        Button(onClick = { showSheet = true }) {
            Text("Show Bottom Sheet")
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Bottom Sheet Content", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(12.dp))
                Text("This is a modal bottom sheet. You can put any content here.")
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { showSheet = false }, modifier = Modifier.fillMaxWidth()) {
                    Text("Close")
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
