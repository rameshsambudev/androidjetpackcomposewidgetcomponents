package com.example.widgets.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class EZListItemData(val title: String, val subtitle: String)

@Composable
fun EZSimpleListItem(item: EZListItemData, onClick: () -> Unit = {}) {
    ListItem(
        headlineContent = { Text(item.title) },
        supportingContent = { Text(item.subtitle) },
        leadingContent = { Icon(Icons.Filled.Person, contentDescription = null) },
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun EZSimpleList(items: List<EZListItemData>, onItemClick: (EZListItemData) -> Unit = {}) {
    LazyColumn {
        items(items) { item ->
            EZSimpleListItem(item = item, onClick = { onItemClick(item) })
            HorizontalDivider()
        }
    }
}

@Composable
fun EZListsShowcase() {
    val sampleItems = listOf(
        EZListItemData("Alice Johnson", "Software Engineer"),
        EZListItemData("Bob Smith", "Product Manager"),
        EZListItemData("Carol White", "UX Designer"),
        EZListItemData("David Brown", "Data Scientist"),
        EZListItemData("Eve Davis", "DevOps Engineer")
    )

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Lists", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        EZSimpleList(items = sampleItems)
    }
}
