package source

class Deck {

    private val cards = buildList {
        add(0)
        for (number in 1..12) {
            repeat(number) {
                add(number)
            }
        }
    }.shuffled().toMutableList()

    fun drawCard(): Int {
        return cards.removeAt(cards.lastIndex)
    }
}
