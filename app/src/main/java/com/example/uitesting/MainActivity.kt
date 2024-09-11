package com.example.uitesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uitesting.ui.theme.UItestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UItestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    //JetpackComposeExample()
                    //LayoutExample()
                    //UIComponentsExample()
                    //LazyListExample()
                    CardExample()
                }
            }
        }
    }
}

// Perustason Modifier, joka on yhteinen useimmille komponenteille
fun Modifier.basicModifier(): Modifier {
    return this
        .padding(16.dp)
}

// Erillinen Modifier erityisesti tekstikentille
fun Modifier.textFieldModifier(): Modifier {
    return this
        .basicModifier() // Käytetään yhteistä modifioijaa
        .padding(vertical = 8.dp) // Lisätään erityinen säätö TextFieldille
}

@Composable
fun JetpackComposeExample() {
    var count by remember { mutableStateOf(0) }


    Column(modifier = Modifier.basicModifier()){
        Button(onClick = { count++ }) {
            Text("Paina minua")
        }
        Row {
            Text("Nappia on painettu $count kertaa")
        }
    }
}

@Composable
fun LayoutExample() {
    Column (modifier = Modifier.basicModifier()){
        Text("Tämä on teksti ylhäällä")
        Spacer(modifier = Modifier.height(36.dp))
        Row {
            Text("Vasen")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Oikea")
        }
    }
}
// vaihda ao. composable mainiin dia 11 -16

@Composable
fun UIComponentsExample() {
    var text by remember { mutableStateOf("Kirjoita tähän") }
    var checked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.basicModifier()) {
        TextField(value = text, onValueChange = { text = it }, modifier = Modifier.textFieldModifier())
        Spacer(modifier = Modifier.height(46.dp))
        CheckBoxExample(checked) { checked = it }
    }
}

@Composable
fun CheckBoxExample(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(modifier = Modifier.basicModifier()) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text("Valinta")
    }
}

// diat 17-18 listat ja ruudut

@Composable
fun LazyListExample() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3", "Item 2", "Item 3333", "Item 2", "Item 3")

    LazyColumn(modifier = Modifier.basicModifier()) {
        items(items) { item ->
            Text(item)
        }
    }
}

// diat 19-22 Card, Dialog, Modifier

@Composable
fun CardExample() {
    Card(
        modifier = Modifier.basicModifier(),
        elevation = CardDefaults.elevatedCardElevation(22.dp)
    ) {
        Text(
            text = "Tämä on kortti",
            modifier = Modifier.padding(16.dp)
        )
    }
}
