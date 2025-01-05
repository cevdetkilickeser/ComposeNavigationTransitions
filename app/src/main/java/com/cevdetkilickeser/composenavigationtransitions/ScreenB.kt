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
fun ScreenB(
    modifier: Modifier = Modifier,
    onNavigateToScreenC: () -> Unit,
    onNavigateToBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        Text("Screen B")
        Button(
            onClick = { onNavigateToScreenC() }
        ) {
            Text(text = "Go To Screen C")
        }
        Button(
            onClick = { onNavigateToBack() }
        ) {
            Text(text = "Turn Back")
        }
    }
}