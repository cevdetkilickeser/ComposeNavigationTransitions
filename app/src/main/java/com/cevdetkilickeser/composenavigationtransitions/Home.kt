package com.cevdetkilickeser.composenavigationtransitions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onNavigateToScreenA: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Home")
        Button(
            onClick = { onNavigateToScreenA() }
        ) {
            Text(text = "Go To Screen A")
        }
    }
}