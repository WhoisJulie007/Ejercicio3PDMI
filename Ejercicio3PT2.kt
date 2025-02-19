package com.example.ejemplo.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable

fun Ejercicio3PT2(){

    var n1 by remember {
        mutableStateOf("")
    }
    var n2 by remember {
        mutableStateOf("")
    }
    var n3 by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }



    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text= "Primer numero:")
        TextField(value = n1, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={
                it
                n1 = it
            }
        )

        Text(text= "Segundo numero")
        TextField(value = n2, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={
                it
                n2 = it
            }
        )

        Text(text= "Tercer numero")
        TextField(value = n3, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange ={
                it
                n3 = it
            }
        )
        Column(modifier =Modifier.padding(top = 20.dp)){}

        Button(onClick = {
            if ((n1.toInt() > n2.toInt()) && (n1.toInt() > n3.toInt())) {
                resultado = n1

            } else if ((n2.toInt() > n1.toInt()) && (n2.toInt() > n3.toInt())) {
                resultado = n2


            } else if ((n3.toInt() > n1.toInt()) && (n3.toInt() > n2.toInt())) {
                resultado = n3

            } else {
                resultado = "Los números iguales"
                println(resultado)

            }

        }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)){
            Text(text = "Numero mayor")
        }
        Button(onClick = {
            if ((n1.toInt() < n2.toInt()) && (n1.toInt() < n3.toInt())) {
                resultado = n1
            } else if ((n2.toInt() < n1.toInt()) && (n2.toInt() < n3.toInt())) {
                resultado = n2
            } else if ((n3.toInt() < n1.toInt()) && (n3.toInt() < n2.toInt())) {
                resultado = n3
            } else {
                resultado = "Los números iguales"
            }


        }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)){
            Text(text = "Numero menor")

        }


        Column(){
            Text("Resultado:")

        }
        Text(text = resultado)

    }}