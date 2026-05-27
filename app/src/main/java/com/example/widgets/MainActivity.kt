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
                WidgetsCatalogApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WidgetsCatalogApp() {
    var selectedSection by remember { mutableIntStateOf(0) }

    val sections = listOf(
        "Buttons", "TextFields", "Lists", "Cards",
        "Switches", "Chips", "Sliders", "Tabs",
        "Dialogs", "Snackbars", "BottomSheet",
        "Progress", "Badges", "Dropdowns", "NavBar"
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Compose Widgets Catalog") })
        },
        bottomBar = {
            BottomNavBarComponent()
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
                    0 -> ButtonsShowcase()
                    1 -> TextFieldsShowcase()
                    2 -> ListsShowcase()
                    3 -> CardsShowcase()
                    4 -> SwitchesShowcase()
                    5 -> ChipsShowcase()
                    6 -> SlidersShowcase()
                    7 -> TabsShowcase()
                    8 -> DialogsShowcase()
                    9 -> SnackbarShowcase()
                    10 -> BottomSheetShowcase()
                    11 -> ProgressIndicatorsShowcase()
                    12 -> BadgesShowcase()
                    13 -> DropdownsShowcase()
                    14 -> NavBarShowcase()
                }
            }
        }
    }
}
