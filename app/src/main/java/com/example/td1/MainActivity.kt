
package com.example.td1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.td1.ViewModel.DiceRollViewModel.DiceViewModel

import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContent {
            DiceApp()
        }
    }
}

@Composable
fun DiceApp(diceViewModel: DiceViewModel = viewModel()) {
    val diceRoll = diceViewModel.diceRoll
    val player1Score = diceViewModel.player1Score
    val player2Score = diceViewModel.player2Score

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Remplacez h4 par titleLarge ou headlineMedium
        Text(text = "Dice Roll: $diceRoll", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Player 1 Score: $player1Score")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Player 2 Score: $player2Score")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceViewModel.rollDice() }) {
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceViewModel.resetGame() }) {
            Text("Reset Game")
        }
    }
}
