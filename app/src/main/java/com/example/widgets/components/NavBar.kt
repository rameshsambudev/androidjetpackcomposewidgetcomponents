package com.example.widgets.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

data class NavItem(val label: String, val icon: @Composable () -> Unit)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(title: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier
    )
}

@Composable
fun BottomNavBarComponent(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Search", "Profile", "Settings")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person, Icons.Filled.Settings)

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBarShowcase() {
    TopAppBar(title = { Text("Navigation Bars") })
    BottomNavBarComponent()
}
