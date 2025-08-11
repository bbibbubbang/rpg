package com.example.mmorpg.systems

data class Stats(
    var level: Int,
    var maxHp: Int,
    var hp: Int,
    var maxMp: Int,
    var mp: Int,
    var exp: Int
) {
    fun addExp(amount: Int) {
        exp += amount
        while (exp >= requiredExpForNextLevel()) {
            exp -= requiredExpForNextLevel()
            levelUp()
        }
    }

    private fun levelUp() {
        level++
        maxHp += 10
        maxMp += 5
        hp = maxHp
        mp = maxMp
    }

    private fun requiredExpForNextLevel(): Int = level * 100
}
