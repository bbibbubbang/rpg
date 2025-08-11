package com.example.mmorpg.systems

class Inventory {
    private val items = mutableListOf<String>()

    fun addItem(item: String) {
        items.add(item)
    }

    fun removeItem(item: String): Boolean = items.remove(item)

    fun listItems(): List<String> = items.toList()
}
