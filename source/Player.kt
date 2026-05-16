package source

class Player(var name: String = "") {

    val hand = ArrayList<Int>()

    var isLost = false
        private set

    val points: Int
        get() = hand.sum()

    val pointsBeforeLastCard: Int
        get() = hand.dropLast(1).sum()

    fun hasCard(card: Int): Boolean {
        return card in hand
    }

    fun handWithCard(card: Int): List<Int> {
        return hand + card
    }

    fun lose() {
        isLost = true
    }

    fun addCard(card: Int) {
        hand.add(card)
    }
}
