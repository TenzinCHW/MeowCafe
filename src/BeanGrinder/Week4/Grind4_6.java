package BeanGrinder.Week4;

/**
 * Created by HanWei on 10/10/2016.
 */
public class Grind4_6 {
    private int songs;
    private boolean activated;

    public Grind4_6(int n) {
        songs = n;
    }

    public void activate() {
        if (!activated) {
            activated = !activated;
        }
    }

    public void buyASong() throws CardEmptyException, CardNotActivatedException {
        if (songs == 0) {
            throw new CardEmptyException();
        }
        if (!activated) {
            throw new CardNotActivatedException();
        } else {
            songs -= 1;
        }
    }

    public int songsRemaining() {
        return songs;
    }

    @Override
    public String toString() {
        String cardDetails;
        cardDetails = String.format("Card has %d songs and is ", songsRemaining());
        if (activated) {
            cardDetails += "activated";
        } else {
            cardDetails += "not activated";
        }
        return cardDetails;
    }

    public static class CardNotActivatedException extends Exception {
        String message = "No more songs on the card";

        public CardNotActivatedException() {
            super();
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public static class CardEmptyException extends Exception {
        String message = "Card not activated";

        public CardEmptyException() {
            super();
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        Grind4_6 sc = new Grind4_6(10);
        System.out.println(sc);

        System.out.println("Trying to buy a song\n");
        try {
            sc.buyASong();
        } catch (CardEmptyException e) {
            System.out.println("Caught error: " + e.getMessage());
        } catch (CardNotActivatedException e) {
            System.out.println("Caught error: " + e.getMessage());
        }
        System.out.println(sc);

        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc + "\n");

        System.out.println("Buying songs");
        String buying;
        for (int i = 0; i < 11; i++) {
            try {
                sc.buyASong();
                buying = String.format("Bought a song: " + sc);
                System.out.println(buying);
            } catch (CardEmptyException e) {
                System.out.println("Caught error: " + e.getMessage());
            } catch (CardNotActivatedException e) {
                System.out.println("Caught error: " + e.getMessage());
            }
        }

        System.out.println(sc);
    }
}
