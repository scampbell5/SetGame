import java.util.HashSet;
import java.util.Scanner;


/*
Main is used as the testing method. Declares N number of games entered by user to rip through
Checks to see how the set matches and reports what property and value matches
Prints out to make it easily visible to verify the set does match, and the property it matches based on
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int numberOfGames;
        System.out.println("How many games would you like to play?");

        //Simple check to prevent from crashing when entering a valid other than a valid int.
        while (!in.hasNextInt()){
            System.out.println("Please enter a valid number of games.");
            in.next();
        }

        numberOfGames = in.nextInt();
        play(numberOfGames);

    }


    //Runs through how many games user enters. Used to verify multiple games while testing.
    private static void play(int numberOfGames){
        boolean continueNextGame = true;
        for (int j = 0; j < numberOfGames; j++) {
            System.out.println("=========================GAME # " + (j + 1) + " =========================");
            Game newGame = new Game();
            newGame.startGame();

            for (int i = 0; i < newGame.getFoundSets().size(); i++) {
                System.out.println("======================= SET # " + (i + 1) + " ==============================================");
                if (!verifySets(newGame.getFoundSets().get(i))){
                    continueNextGame = false;
                    break;
                }
                System.out.println("========================END SET===============================================");
            }
            if (!continueNextGame){
                break;
            }
            System.out.println("===================END OF GAME # " + (j + 1) + " =========================");

        }
    }

    //Testing method used to verify matches in set and make it easily visible for visual comparison
    //A set may match based on more than one property, but it will report the first matching property.
    private static boolean verifySets(HashSet<Card> foundSets) {
        Card[] cards = new Card[foundSets.size()];
        foundSets.toArray(cards);

        if (verifyColor(cards[0], cards[1], cards[2])){
            System.out.println("COLORS MATCH == " + cards[0].getColor());
        }else if (verifyShape(cards[0], cards[1], cards[2])) {
            System.out.println("SHAPES MATCH == " + cards[0].getShape());
        }else if (verifyShading(cards[0], cards[1], cards[2])) {
            System.out.println("SHADING MATCH == " + cards[0].getShading());
        }else if (verifyNumber(cards[0], cards[1], cards[2])) {
            System.out.println("NUMBERS MATCH == " + cards[0].getNumber());
        }else if (verifyNoMatches(cards[0], cards[1], cards[2])) {
            System.out.println("NO MATCH == NO PROPERTIES MATCH");
        }else{
            System.out.println("TEST FAILED, cards are not reporting as matching correctly.");
            System.out.println(cards[0]);
            System.out.println(cards[1]);
            System.out.println(cards[2]);
            return false;
        }
        System.out.println(cards[0]);
        System.out.println(cards[1]);
        System.out.println(cards[2]);
        return true;
    }

    private static boolean verifyNoMatches(Card a, Card b, Card c) {
        boolean numbersNotMatch = !a.getNumber().equals(b.getNumber()) && !a.getNumber().equals(c.getNumber()) && !b.getNumber().equals(c.getNumber());
        boolean shapesNotMatch = !a.getShape().equals(b.getShape()) && !a.getShape().equals(c.getShape()) && !b.getShape().equals(c.getShape());
        boolean shadingNotMatch = !a.getShading().equals(b.getShading()) && !a.getShading().equals(c.getShading()) && !b.getShading().equals(c.getShading());
        boolean colorNotMatch = !a.getColor().equals(b.getColor()) && !a.getColor().equals(c.getColor()) && !b.getColor().equals(c.getColor());
        return (numbersNotMatch && shapesNotMatch && shadingNotMatch && colorNotMatch);
    }

    //Verify matches based on color.
    private static boolean verifyColor(Card a, Card b, Card c){
        Color aColor = a.getColor();
        Color bColor = b.getColor();
        Color cColor = c.getColor();
        return aColor.equals(bColor) && aColor.equals(cColor);
    }

    //Verify matches based on shape.
    private static boolean verifyShape(Card a, Card b, Card c){
        Shape aShape = a.getShape();
        Shape bShape = b.getShape();
        Shape cShape = c.getShape();
        return aShape.equals(bShape) && aShape.equals(cShape);
    }

    //Verify matches based on shading.
    private static boolean verifyShading(Card a, Card b, Card c){
        Shading aShading = a.getShading();
        Shading bShading = b.getShading();
        Shading cShading = c.getShading();
        return aShading.equals(bShading) && aShading.equals(cShading);
    }

    //Verify matches based on number.
    private static boolean verifyNumber(Card a, Card b, Card c){
        Number aNumber = a.getNumber();
        Number bNumber = b.getNumber();
        Number cNumber = c.getNumber();
        return aNumber.equals(bNumber) && aNumber.equals(cNumber);
    }

}
