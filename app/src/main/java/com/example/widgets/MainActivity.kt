package com.example.widgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.widgets.components.*
import com.example.widgets.ui.theme.WidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WidgetsTheme {
                EZWidgetsCatalogApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZWidgetsCatalogApp() {
    var selectedSection by remember { mutableIntStateOf(0) }

    val sections = listOf(
        "Buttons", "TextFields", "Lists", "Cards",
        "Switches", "Chips", "Sliders", "Tabs",
        "Dialogs", "Snackbars", "BottomSheet",
        "Progress", "Badges", "Dropdowns", "NavBar"
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("EZ Compose Widgets Catalog") })
        },
        bottomBar = {
            EZBottomNavBar()
        }
    ) { padding ->
        Row(modifier = Modifier.padding(padding).fillMaxSize()) {
            NavigationRail(modifier = Modifier.fillMaxHeight()) {
                sections.forEachIndexed { index, section ->
                    NavigationRailItem(
                        selected = selectedSection == index,
                        onClick = { selectedSection = index },
                        icon = { },
                        label = { Text(section, style = MaterialTheme.typography.labelSmall) }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                when (selectedSection) {
                    0 -> EZButtonsShowcase()
                    1 -> EZTextFieldsShowcase()
                    2 -> EZListsShowcase()
                    3 -> EZCardsShowcase()
                    4 -> EZSwitchesShowcase()
                    5 -> EZChipsShowcase()
                    6 -> EZSlidersShowcase()
                    7 -> EZTabsShowcase()
                    8 -> EZDialogsShowcase()
                    9 -> EZSnackbarShowcase()
                    10 -> EZBottomSheetShowcase()
                    11 -> EZProgressIndicatorsShowcase()
                    12 -> EZBadgesShowcase()
                    13 -> EZDropdownsShowcase()
                    14 -> EZNavBarShowcase()
                }
            }
        }
    }
}
