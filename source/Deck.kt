package source

import java.util.Collections

class Deck {

    private val cards = ArrayList<Int>()

    init {
        cards.add(0)
        for (number in 1..12) {
            repeat(number) {
                cards.add(number)
            }
        }
        Collections.shuffle(cards)
    }

    fun drawCard(): Int {
        return cards.removeAt(cards.lastIndex)
    }
}
