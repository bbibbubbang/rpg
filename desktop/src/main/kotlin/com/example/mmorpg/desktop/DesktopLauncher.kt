package com.example.mmorpg.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.example.mmorpg.MyGame

object DesktopLauncher {
    @JvmStatic
    fun main(args: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration().apply {
            setTitle("MMORPG")
            setWindowedMode(800, 600)
        }
        Lwjgl3Application(MyGame(), config)
    }
}
