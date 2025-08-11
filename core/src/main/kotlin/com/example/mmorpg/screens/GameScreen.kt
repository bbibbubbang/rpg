package com.example.mmorpg.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.example.mmorpg.entities.Player

class GameScreen : ScreenAdapter() {
    private val batch = SpriteBatch()
    private val player = Player()

    override fun render(delta: Float) {
        player.update(delta)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        player.render(batch)
        player.renderUI(batch)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
    }
}
