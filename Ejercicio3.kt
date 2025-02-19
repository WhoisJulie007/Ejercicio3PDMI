package com.example.ejemplo.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo.R

/*
Esto es una prueba
 */

@Preview(showBackground = true)
@Composable

fun Calculadora(){
    var firstNumber by remember {
        mutableStateOf("")
    }

    var secondNumber by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Primer número")
        TextField(value = firstNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Escribe el primer numero")},
            onValueChange = {
                    textoIngresado ->
                firstNumber = textoIngresado
            } )
        Text(text = "Segundo número")
        TextField(value = secondNumber,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Escribe el segundo numero")},
            onValueChange = {
                    textoIngresado ->
                secondNumber = textoIngresado
            } )
        Button(onClick = {
            resultado = (firstNumber.toInt() + secondNumber.toInt()).toString()

        }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )){
            Text(text = "Sumar")

        }
        OutlinedButton (onClick = {
            resultado = (firstNumber.toInt() - secondNumber.toInt()).toString()

        }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Red
            )){
            Text(text = "Restar")

        }

        IconButton(onClick = {
            resultado = (firstNumber.toInt() * secondNumber.toInt()).toString()

        }, modifier = Modifier.size(90.dp)) {Text(text = "Multiplicar") }
        Image(painter = painterResource(id = R.drawable.camila),
            contentDescription = "Dividir",
            modifier = Modifier
                .clickable {
                    resultado = (firstNumber.toInt() / secondNumber.toInt()).toString()

                }
                .size(90.dp),
            contentScale = ContentScale.Crop,
        )
        Text(text = resultado)
    }
}