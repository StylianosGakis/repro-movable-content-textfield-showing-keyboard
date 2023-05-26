package xyz.stylianosgakis.repro_movablecontent_textfield_keyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.stylianosgakis.repro_movablecontent_textfield_keyboard.ui.theme.RepromovablecontenttextfieldkeyboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepromovablecontenttextfieldkeyboardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val movableTextField = remember {
                        movableContentOf {
                            TextField(
                                "Test",
                                {},
                            )
                        }
                    }
                    Column {
                        var isColumn by remember { mutableStateOf(false) }
                        Button({ isColumn = !isColumn }) {
                            Text(text = "Move the movableContent")
                        }
                        if (isColumn) {
                            Column {
                                Spacer(
                                    Modifier
                                        .size(150.dp)
                                        .background(Color.Red)
                                )
                                movableTextField()
                            }
                        } else {
                            Row {
                                Spacer(
                                    Modifier
                                        .size(150.dp)
                                        .background(Color.Red)
                                )
                                movableTextField()
                            }
                        }
                    }
                }
            }
        }
    }
}
