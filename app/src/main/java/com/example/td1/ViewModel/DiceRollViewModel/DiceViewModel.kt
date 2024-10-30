package com.example.td1.ViewModel.DiceRollViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlin.random.Random

class DiceViewModel : ViewModel() {
    var diceRoll by mutableStateOf(1)
        private set

    var player1Score by mutableStateOf(0)
        private set

    var player2Score by mutableStateOf(0)
        private set

    fun rollDice() {
        diceRoll = Random.nextInt(1, 7)  // Génère un nombre entre 1 et 6
        // Ici, on accumule les points pour le joueur 1 en guise d'exemple
        player1Score += diceRoll
    }

    fun resetGame() {
        diceRoll = 1
        player1Score = 0
        player2Score = 0
    }
}
