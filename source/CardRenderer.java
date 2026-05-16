package source;

import java.util.List;

public class CardRenderer {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static String renderHand(List<Integer> cards) {
        return renderHand(cards, null);
    }

    public static String renderHandWithDuplicate(List<Integer> cards) {
        if (cards.isEmpty()) {
            return renderHand(cards);
        }

        return renderHand(cards, cards.get(cards.size() - 1));
    }

    private static String renderHand(List<Integer> cards, Integer highlightedCard) {
        if (cards.isEmpty()) {
            return "(empty)";
        }

        StringBuilder top = new StringBuilder();
        StringBuilder middle = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        for (int card : cards) {
            boolean highlighted = highlightedCard != null && card == highlightedCard;

            top.append("┌────┐ ");
            middle.append("│ ").append(formatCardNumber(card, highlighted)).append(" │ ");
            bottom.append("└────┘ ");
        }

        return top.toString().stripTrailing()
            + System.lineSeparator()
            + middle.toString().stripTrailing()
            + System.lineSeparator()
            + bottom.toString().stripTrailing();
    }

    private static String formatCardNumber(int card, boolean highlighted) {
        String number = String.format("%2d", card);

        if (highlighted) {
            return RED + number + RESET;
        }

        return number;
    }
}
