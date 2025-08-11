package com.example.mmorpg

import com.badlogic.gdx.Game
import com.example.mmorpg.screens.GameScreen

class MyGame : Game() {
    override fun create() {
        setScreen(GameScreen())
    }
}
