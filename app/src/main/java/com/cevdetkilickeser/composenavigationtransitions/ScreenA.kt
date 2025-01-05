package com.cevdetkilickeser.composenavigationtransitions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ScreenA(
    modifier: Modifier = Modifier,
    onNavigateToScreenB: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize().background(color = Color.Red)
    ) {
        Text("Screen A")
        Button(
            onClick = { onNavigateToScreenB() }
        ) {
            Text(text = "Go To Screen B")
        }
    }
}