package com.example.android.marsrealestate

class Main(val clickListener: (Int) -> Unit) {
    var i = 0

    fun onClick(id: Int) = clickListener(id)
}


fun main() {
    var res = 10

    val x = Main{
        println("from >> " + 5)
    }

    x.onClick(5)


}