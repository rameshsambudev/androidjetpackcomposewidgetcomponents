package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EZSlider(value: Float, onValueChange: (Float) -> Unit, modifier: Modifier = Modifier) {
    Slider(value = value, onValueChange = onValueChange, modifier = modifier)
}

@Composable
fun EZRangeSlider(
    range: ClosedFloatingPointRange<Float>,
    onRangeChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier
) {
    RangeSlider(value = range, onValueChange = onRangeChange, modifier = modifier)
}

@Composable
fun EZSlidersShowcase() {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    var rangeValue by remember { mutableStateOf(0.2f..0.8f) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Sliders", style = MaterialTheme.typography.titleLarge)

        Text("Slider: ${(sliderValue * 100).toInt()}%")
        EZSlider(value = sliderValue, onValueChange = { sliderValue = it })

        Text("Range: ${(rangeValue.start * 100).toInt()}% - ${(rangeValue.endInclusive * 100).toInt()}%")
        EZRangeSlider(range = rangeValue, onRangeChange = { rangeValue = it })
    }
}
