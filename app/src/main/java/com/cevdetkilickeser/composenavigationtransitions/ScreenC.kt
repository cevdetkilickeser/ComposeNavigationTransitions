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
fun ScreenC(
    modifier: Modifier = Modifier,
    onNavigateToBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    ) {
        Text("Screen C")
        Button(
            onClick = { onNavigateToBack() }
        ) {
            Text(text = "Turn Back")
        }
    }
}