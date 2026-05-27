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

data class ListItemData(val title: String, val subtitle: String)

@Composable
fun SimpleListItem(item: ListItemData, onClick: () -> Unit = {}) {
    ListItem(
        headlineContent = { Text(item.title) },
        supportingContent = { Text(item.subtitle) },
        leadingContent = { Icon(Icons.Filled.Person, contentDescription = null) },
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun SimpleList(items: List<ListItemData>, onItemClick: (ListItemData) -> Unit = {}) {
    LazyColumn {
        items(items) { item ->
            SimpleListItem(item = item, onClick = { onItemClick(item) })
            HorizontalDivider()
        }
    }
}

@Composable
fun ListsShowcase() {
    val sampleItems = listOf(
        ListItemData("Alice Johnson", "Software Engineer"),
        ListItemData("Bob Smith", "Product Manager"),
        ListItemData("Carol White", "UX Designer"),
        ListItemData("David Brown", "Data Scientist"),
        ListItemData("Eve Davis", "DevOps Engineer")
    )

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Lists", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        SimpleList(items = sampleItems)
    }
}
