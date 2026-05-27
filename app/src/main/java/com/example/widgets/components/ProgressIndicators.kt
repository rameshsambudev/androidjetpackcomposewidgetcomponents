package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressComponent(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

@Composable
fun LinearProgressComponent(progress: Float, modifier: Modifier = Modifier) {
    LinearProgressIndicator(progress = { progress }, modifier = modifier.fillMaxWidth())
}

@Composable
fun IndeterminateLinearProgress(modifier: Modifier = Modifier) {
    LinearProgressIndicator(modifier = modifier.fillMaxWidth())
}

@Composable
fun ProgressIndicatorsShowcase() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Progress Indicators", style = MaterialTheme.typography.titleLarge)
        CircularProgressComponent()
        LinearProgressComponent(progress = 0.7f)
        IndeterminateLinearProgress()
    }
}
