package vanhack.Q2;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Ordering;

import java.util.*;
import java.util.function.Function;

import static com.google.common.collect.Ordering.from;
import static com.google.common.collect.Ordering.natural;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class PokerHand {
    public enum Result {TIE, WIN, LOSS}

    public enum Suit {D, C, H, S}

    public enum Rank {
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("T"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        ACE("A");
        private String value;

        Rank(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Rank findBy(String value) {
            return Arrays.stream(Rank.values())
                    .filter(e -> e.getValue().equalsIgnoreCase(value))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Rank supplied"));
        }
    }

    public enum Category {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH;
    }

    public Category category;

    public class Card {
        private final String rank, suit;

        Card(String suit, String rank) {
            this.rank = rank;
            this.suit = suit;
        }

        public String getRank() {
            return rank;
        }

        public String getSuit() {
            return suit;
        }
    }

    private final LinkedList<Rank> distinctRanks = new LinkedList<>();
    private static final Ordering<Entry<Rank>> byCountThenRank;

    static {
        Comparator<Entry<Rank>> byCount = comparingInt(Entry::getCount);
        Comparator<Entry<Rank>> byRank = comparing(Entry::getElement);
        byCountThenRank = from(byCount.thenComparing(byRank));
    }

    private static final Comparator<PokerHand> byCategoryThenRanks;

    static {
        Comparator<PokerHand> byCategory = comparing((PokerHand hand) -> hand.category);
        Function<PokerHand, Iterable<Rank>> getRanks = (PokerHand hand) -> hand.distinctRanks;
        Comparator<PokerHand> byRanks = comparing(getRanks, natural().lexicographical());
        byCategoryThenRanks = byCategory.thenComparing(byRanks);
    }

    public PokerHand(String hand) {
        Set<Card> cards = prepareCard(hand);
        Set<Suit> suits = EnumSet.noneOf(Suit.class);
        Multiset<Rank> ranks = EnumMultiset.create(Rank.class);
        for (Card card : cards) {
            suits.add(Suit.valueOf(card.getSuit()));
            ranks.add(PokerHand.Rank.findBy(card.getRank()));
        }
        for (Entry<Rank> entry : byCountThenRank.immutableSortedCopy(ranks.entrySet())) {
            distinctRanks.addFirst(entry.getElement());
        }
        Rank first = distinctRanks.getFirst();
        int distinctCount = distinctRanks.size();
        if (distinctCount == 5) {
            boolean flush = suits.size() == 1;
            if (first.ordinal() - distinctRanks.getLast().ordinal() == 4) {
                category = flush ? Category.STRAIGHT_FLUSH : Category.STRAIGHT;
            } else if (first == Rank.ACE && distinctRanks.get(1) == Rank.FIVE) {
                category = flush ? Category.STRAIGHT_FLUSH : Category.STRAIGHT;
                distinctRanks.addLast(distinctRanks.removeFirst());
            } else {
                category = flush ? Category.FLUSH : Category.HIGH_CARD;
            }
        } else if (distinctCount == 4) {
            category = Category.ONE_PAIR;
        } else if (distinctCount == 3) {
            category = ranks.count(first) == 2 ? Category.TWO_PAIR : Category.THREE_OF_A_KIND;
        } else {
            category = ranks.count(first) == 3 ? Category.FULL_HOUSE : Category.FOUR_OF_A_KIND;
        }
    }

    public Result compareWith(PokerHand that) {
        int result = byCategoryThenRanks.compare(this, that);
        return result == 0 ? Result.TIE : result >= 1 ? Result.WIN : Result.LOSS;
    }

    private Set<PokerHand.Card> prepareCard(String hand) {
        HashSet<String> cards = new HashSet<>(Arrays.asList(hand.split(" ")));
        Set<Card> cardSet = new HashSet<>();
        cards.forEach(each -> cardSet.add(new Card(String.valueOf(each.charAt(1)), String.valueOf(each.charAt(0)))));
        return cardSet;
    }
}