package co.id.test_apps.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.id.test_apps.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val valuePrima = remember { mutableStateOf("") }
    val result      = remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Icon(painter = painterResource(id =R.drawable.logo), contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary)
                }
                Column {
                    Text(text = "Bilangan Prima", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Masukan angka untuk menghasilkan bilangan prima")
                }
                TextField(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                    value = valuePrima.value, onValueChange = {
                    valuePrima.value = it
                }, label = { Text(text = "Input Angka")}, placeholder = { Text(text = "Input Angka")},
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Button(
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    onClick = {
                        result.value = GenerateBilanganPrima(if(valuePrima.value == "") 0 else valuePrima.value.toInt() )
                    }) {
                    Text(text = "GENERATE BILANGAN PRIMA")
                }

                if(result.value != "") {
                    Text(text = GenerateBilanganPrima(valuePrima.value.toInt()))
                }
            }
        }
    }
}

fun GenerateBilanganPrima(input : Int) : String {
    var result = ""
    for(i in 1..input) {
        if(checkNumberPrima(i)) {
            result += i.toString()+"\r\r"
        }
    }
    return result
}

fun checkNumberPrima(input : Int) : Boolean {
    var number = 0;
    for(i in 1..input) {
        if(input % i == 0) {
            number++
        }
    }

    if(number == 2) {
        return true
    }
    return false
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}