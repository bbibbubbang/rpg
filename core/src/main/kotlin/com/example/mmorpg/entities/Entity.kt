package com.example.mmorpg.entities

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2

open class Entity(
    var position: Vector2 = Vector2(0f, 0f),
    val texture: Texture
) {
    open fun update(delta: Float) {
        // Common update logic
    }

    open fun render(batch: SpriteBatch) {
        batch.draw(texture, position.x, position.y)
    }
}
