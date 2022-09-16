package com.developer.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.developer.todo.viewModel.viewModel.CalculatorViewModel

@Composable
fun CalculatorClassic() {
    val CalculatorViewModel: CalculatorViewModel = viewModel()
    val result = CalculatorViewModel.result.observeAsState("0")
    var san1 = remember { mutableStateOf("") }
    var san2 = remember { mutableStateOf("") }
    var netije = remember { mutableStateOf("0") }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = result.value)

        OutlinedTextField(
            value = san1.value,
            onValueChange = { san1.value = it },
            label = { Text(text = "San 1") })
        OutlinedTextField(
            value = san2.value,
            onValueChange = { san2.value = it },
            label = { Text(text = "San 2") })
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(onClick = {
                CalculatorViewModel.addition(san1.value, san2.value)
            }) {
                Text(text = "+")
            }
            OutlinedButton(onClick = {
                CalculatorViewModel.subtraction(san1.value, san2.value)
            }) {
                Text(text = "-")
            }

            OutlinedButton(onClick = {
                CalculatorViewModel.multiplication(san1.value, san2.value)
            }) {
                Text(text = "*")
            }

            OutlinedButton(onClick = {
                CalculatorViewModel.division(san1.value, san2.value)
            }) {
                Text(text = "/")
            }


        }

    }
}