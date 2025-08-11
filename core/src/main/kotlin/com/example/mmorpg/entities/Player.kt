package com.example.mmorpg.entities

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.example.mmorpg.systems.Inventory
import com.example.mmorpg.systems.Stats
import com.example.mmorpg.utils.Constants

class Player(position: Vector2 = Vector2(50f, 50f)) : Entity(position, createTexture()) {

    var stats = Stats(
        level = 1,
        maxHp = 100,
        hp = 100,
        maxMp = 30,
        mp = 30,
        exp = 0
    )
    val inventory = Inventory()
    private val speed = 100f

    override fun update(delta: Float) {
        handleInput(delta)
    }

    private fun handleInput(delta: Float) {
        val move = Vector2()
        if (Gdx.input.isKeyPressed(Constants.KEY_UP)) move.y += speed
        if (Gdx.input.isKeyPressed(Constants.KEY_DOWN)) move.y -= speed
        if (Gdx.input.isKeyPressed(Constants.KEY_LEFT)) move.x -= speed
        if (Gdx.input.isKeyPressed(Constants.KEY_RIGHT)) move.x += speed
        position.add(move.scl(delta))
    }

    fun renderUI(batch: SpriteBatch) {
        // Draw HP, MP, level etc. using BitmapFont in a real game
    }

    companion object {
        private fun createTexture(): Texture {
            val pixmap = Pixmap(16, 16, Pixmap.Format.RGBA8888)
            pixmap.setColor(Color.BLUE)
            pixmap.fill()
            val texture = Texture(pixmap)
            pixmap.dispose()
            return texture
        }
    }
}
