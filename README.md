# Android Jetpack Compose Widget Components (EZ Widgets)

A reusable component library showcasing all common Jetpack Compose Material 3 widgets. All components are prefixed with `EZ` for easy identification. Use these as building blocks in your own projects.

## Components

| Component | File | Description |
|-----------|------|-------------|
| EZButtons | `Buttons.kt` | EZPrimaryButton, EZSecondaryButton, EZTertiaryButton, EZIconButton, EZFloatingActionButton |
| EZTextFields | `TextFields.kt` | EZBasicTextField, EZOutlinedTextField, EZPasswordTextField, EZEmailTextField |
| EZLists | `Lists.kt` | EZSimpleList, EZSimpleListItem |
| EZCards | `Cards.kt` | EZBasicCard, EZElevatedCard, EZOutlinedCard |
| EZNavBar | `NavBar.kt` | EZTopAppBar, EZBottomNavBar |
| EZSwitches | `Switches.kt` | EZSwitch, EZCheckbox, EZRadioButtonGroup |
| EZChips | `Chips.kt` | EZFilterChip, EZInputChip |
| EZSliders | `Sliders.kt` | EZSlider, EZRangeSlider |
| EZTabs | `Tabs.kt` | EZTabRow |
| EZDialogs | `Dialogs.kt` | EZAlertDialog |
| EZSnackbars | `Snackbars.kt` | EZSnackbarShowcase |
| EZBottomSheet | `BottomSheet.kt` | EZBottomSheetShowcase |
| EZProgress | `ProgressIndicators.kt` | EZCircularProgress, EZLinearProgress, EZIndeterminateLinearProgress |
| EZBadges | `Badges.kt` | EZBadgedIcon |
| EZDropdowns | `Dropdowns.kt` | EZDropdownMenu |

## Project Structure

```
app/src/main/java/com/example/widgets/
├── MainActivity.kt              # Catalog app with navigation
├── components/
│   ├── Badges.kt
│   ├── BottomSheet.kt
│   ├── Buttons.kt
│   ├── Cards.kt
│   ├── Chips.kt
│   ├── Dialogs.kt
│   ├── Dropdowns.kt
│   ├── Lists.kt
│   ├── NavBar.kt
│   ├── ProgressIndicators.kt
│   ├── Sliders.kt
│   ├── Snackbars.kt
│   ├── Switches.kt
│   ├── Tabs.kt
│   └── TextFields.kt
└── ui/theme/
    └── Theme.kt
```

## Usage

Import any component directly into your composables:

```kotlin
import com.example.widgets.components.*
```

### Buttons

```kotlin
EZPrimaryButton(text = "Submit", onClick = { /* handle click */ })

EZSecondaryButton(text = "Cancel", onClick = { /* handle click */ })

EZTertiaryButton(text = "Learn More", onClick = { /* handle click */ })

EZIconButton(onClick = { /* toggle favorite */ })

EZFloatingActionButton(onClick = { /* add item */ })
```

### TextFields

```kotlin
var name by remember { mutableStateOf("") }
var email by remember { mutableStateOf("") }
var password by remember { mutableStateOf("") }

EZBasicTextField(value = name, onValueChange = { name = it }, label = "Full Name")

EZOutlinedTextField(value = name, onValueChange = { name = it }, label = "Username")

EZEmailTextField(value = email, onValueChange = { email = it })

EZPasswordTextField(value = password, onValueChange = { password = it })
```

### Lists

```kotlin
val users = listOf(
    EZListItemData("Alice", "Engineer"),
    EZListItemData("Bob", "Designer"),
    EZListItemData("Carol", "Manager")
)

EZSimpleList(items = users, onItemClick = { item ->
    // handle item tap
})
```

### Cards

```kotlin
EZBasicCard(title = "Welcome", description = "This is a filled card")

EZElevatedCard(title = "Stats", description = "Card with shadow elevation")

EZOutlinedCard(title = "Info", description = "Card with border outline")
```

### Navigation Bar

```kotlin
Scaffold(
    topBar = { EZTopAppBar(title = "My App") },
    bottomBar = { EZBottomNavBar() }
) { padding ->
    // screen content
}
```

### Switches, Checkboxes & Radio Buttons

```kotlin
var wifiEnabled by remember { mutableStateOf(true) }
var agreed by remember { mutableStateOf(false) }
var selected by remember { mutableStateOf("Option A") }

EZSwitch("Wi-Fi", wifiEnabled) { wifiEnabled = it }

EZCheckbox("I agree to terms", agreed) { agreed = it }

EZRadioButtonGroup(
    options = listOf("Option A", "Option B", "Option C"),
    selectedOption = selected,
    onOptionSelected = { selected = it }
)
```

### Chips

```kotlin
var isSelected by remember { mutableStateOf(false) }

EZFilterChip("Kotlin", isSelected) { isSelected = it }

EZInputChip(label = "Tag", onDismiss = { /* remove chip */ })
```

### Sliders

```kotlin
var volume by remember { mutableFloatStateOf(0.5f) }
var priceRange by remember { mutableStateOf(0.2f..0.8f) }

EZSlider(value = volume, onValueChange = { volume = it })

EZRangeSlider(range = priceRange, onRangeChange = { priceRange = it })
```

### Tabs

```kotlin
EZTabRow() // Renders Home, Favorites, Profile tabs with icons
```

### Dialogs

```kotlin
var showDialog by remember { mutableStateOf(false) }

EZAlertDialog(
    showDialog = showDialog,
    onDismiss = { showDialog = false },
    onConfirm = { showDialog = false },
    title = "Delete Item",
    message = "Are you sure you want to delete this?"
)
```

### Snackbar

```kotlin
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

Button(onClick = {
    scope.launch {
        snackbarHostState.showSnackbar(
            message = "Item deleted",
            actionLabel = "Undo",
            duration = SnackbarDuration.Short
        )
    }
}) { Text("Delete") }

SnackbarHost(hostState = snackbarHostState)
```

### Bottom Sheet

```kotlin
EZBottomSheetShowcase()
```

### Progress Indicators

```kotlin
EZCircularProgress()

EZLinearProgress(progress = 0.65f)

EZIndeterminateLinearProgress()
```

### Badges

```kotlin
EZBadgedIcon(count = 3) {
    Icon(Icons.Filled.Email, contentDescription = "Mail")
}
```

### Dropdowns

```kotlin
var language by remember { mutableStateOf("Kotlin") }

EZDropdownMenu(
    options = listOf("Kotlin", "Java", "Swift", "Dart"),
    selectedOption = language,
    onOptionSelected = { language = it },
    label = "Language"
)
```

Each file also has an `EZ*Showcase()` composable for quick demo/preview.

## Tech Stack

- Kotlin
- Jetpack Compose (Material 3)
- Compose BOM 2024.01.00
- Min SDK 24 / Target SDK 34

## Setup

1. Clone the repo
2. Open in Android Studio
3. Sync Gradle and run on emulator/device

## License

MIT
