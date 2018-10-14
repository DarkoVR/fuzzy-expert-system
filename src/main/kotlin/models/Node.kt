package models

import java.util.ArrayList


class Node(val name: String, val label: String, val value: Double, val parent: Node?) {
    private var children: MutableList<Node>? = null

    init {
        this.children = ArrayList()
    }

    fun addChild(child: Node) {
        children!!.add(child)
    }

    fun getChildrens(): MutableList<Node>? {
        return this.children
    }

    fun getChildrensData(): ArrayList<String> {
        val data: ArrayList<String> = ArrayList()
        this.children?.forEach {
            data.add("${it.name} ${it.label} ${it.value}")
        }
        return data
    }
}