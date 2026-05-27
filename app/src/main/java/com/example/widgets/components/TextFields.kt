package com.example.widgets.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun BasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun OutlinedTextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Password") },
        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Email") },
        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun TextFieldsShowcase() {
    var basic by remember { mutableStateOf("") }
    var outlined by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Text Fields", style = MaterialTheme.typography.titleLarge)
        BasicTextField(value = basic, onValueChange = { basic = it }, label = "Basic TextField")
        OutlinedTextFieldComponent(value = outlined, onValueChange = { outlined = it }, label = "Outlined TextField")
        PasswordTextField(value = password, onValueChange = { password = it })
        EmailTextField(value = email, onValueChange = { email = it })
    }
}
