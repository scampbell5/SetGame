import java.util.*;

/*
A game of set consists of a deck of 81 cards.
The board initializes with 12 cards
As soon as a matching set is found, those cards are removed from the board and 3 new cards are added
This continues until all cards have been dealt and there are no more cards that form a valid set.
A valid set can be 3 of the same number, color, shading or shape OR all properties have to be different.
*/

public class Game {

    private Stack<Card> deck = new Stack<>();
    private boolean gameOver = false;
    private ArrayList<Card> board;
    private ArrayList<HashSet<Card>> foundSets = new ArrayList<>();


    public Game (){
        //Builds a shuffled deck of cards.
        deck.addAll(buildDeck());
        board = new ArrayList<>();
    }

    //Builds a deck of cards and then returns a shuffled deck.
    //Uses Java's Collections.shuffle method to shuffle the deck.
    private ArrayList<Card> buildDeck (){
        ArrayList<Card> deck = new ArrayList<>();
        for (int colorIndex = 0; colorIndex < 3; colorIndex++){
            Color currentColor = new Color(colorIndex);
            for (int shapeIndex = 0; shapeIndex < 3; shapeIndex++){
                Shape currentShape = new Shape(shapeIndex);
                for (int shadingIndex = 0; shadingIndex < 3; shadingIndex++){
                    Shading currentShading = new Shading(shadingIndex);
                    for (int numberIndex = 0; numberIndex < 3; numberIndex++){
                        Number currentNumber = new Number(numberIndex);
                        Card currentCard = new Card(currentColor,currentShape,currentShading,currentNumber);
                        deck.add(currentCard);
                    }
                }
            }
        }

        //Shuffles the deck of cards.
        Collections.shuffle(deck);
        return deck;
    }


    //Returns true if the cards form a valid set or false if the cards are not a valid set.
    //Valid set can be numbers, shapes, colors or shading all matches OR they are all different.
    private boolean isValidSet(Card a, Card b, Card c){

        boolean colorsMatch = a.getColor().equals(b.getColor()) && a.getColor().equals(c.getColor());
        boolean shapesMatch = a.getShape().equals(b.getShape()) && a.getShape().equals(c.getShape());
        boolean shadingMatch = a.getShading().equals(b.getShading()) && a.getShading().equals(c.getShading());
        boolean numbersMatch = a.getNumber().equals(b.getNumber()) && a.getNumber().equals(c.getNumber());
        boolean numbersNotMatch = !a.getNumber().equals(b.getNumber()) && !a.getNumber().equals(c.getNumber()) && !b.getNumber().equals(c.getNumber());
        boolean shapesNotMatch = !a.getShape().equals(b.getShape()) && !a.getShape().equals(c.getShape()) && !b.getShape().equals(c.getShape());
        boolean shadingNotMatch = !a.getShading().equals(b.getShading()) && !a.getShading().equals(c.getShading()) && !b.getShading().equals(c.getShading());
        boolean colorNotMatch = !a.getColor().equals(b.getColor()) && !a.getColor().equals(c.getColor()) && !b.getColor().equals(c.getColor());

        return (colorsMatch || shapesMatch || shadingMatch || numbersMatch) || (numbersNotMatch && shapesNotMatch && shadingNotMatch && colorNotMatch);
    }


    //Finds a valid set of cards to remove from the board.
    private Set<Card> findSet(ArrayList<Card> board){
        HashSet<Card> validSet = new HashSet<>();

        //Sorts cards by color, returning the first 3 occurrences of the same color.
        Collections.sort(board, new SortCardByColor());
        if (validSet.addAll(findMatchBy(board))){
            if (!validSet.isEmpty()){
                return validSet;
            }
        }

        //Sorts cards by number, returning the first 3 occurrences of the same number.
        Collections.sort(board, new SortCardByNumber());
        if (validSet.addAll(findMatchBy(board))){
            if (!validSet.isEmpty()){
                return validSet;
            }
        }

        //Sorts cards by shading, returning the first 3 occurrences of the same shading.
        Collections.sort(board, new SortCardByShading());
        if (validSet.addAll(findMatchBy(board))){
            if (!validSet.isEmpty()){
                return validSet;
            }
        }

        //Sorts cards by shape, returning the first 3 occurrences of the same shape.
        Collections.sort(board, new SortCardByShape());
        if (validSet.addAll(findMatchBy(board))){
            if (!validSet.isEmpty()){
                return validSet;
            }
        }
        return validSet;
    }

    //After the cards have been sorted based on color, number, shading or shape, iterate through board
    //to find the first 3 occurrences of cards with the same property. Since the board is sorted based property
    //same properties will all be grouped, allowing us to iterate through the board just once looking at adjacent cards.
    private Set<Card> findMatchBy(ArrayList<Card> board){
        HashSet<Card> validSet = new HashSet<>();
        for (int i = 0; i < board.size() - 2; i++){
            Card a = board.get(i);
            Card b = board.get(i + 1);
            Card c = board.get(i + 2);
            if (isValidSet(a, b, c)){
                validSet.add(a);
                validSet.add(b);
                validSet.add(c);
                return validSet;
            }
        }
        return validSet;
    }

    //Plays a full game of Set! or prints the results from a finished game.
    public void startGame(){
        if (!gameOver) {
            initializeBoard();
            while (!deck.empty()) {
                HashSet<Card> foundSet = (HashSet<Card>) findSet(board);
                if (!foundSet.isEmpty()) {
                    foundSets.add(foundSet);
                    board.removeAll(foundSet);
                }
                dealCards();
            }

            //Scans the board to find all remaining sets.
            findRemainingSets();
            gameOver = true;
        }
        System.out.println("GAME OVER! Please see below for the Board State and all sets found!");
        printBoardState();
        printFoundSets();
    }

    //Method is used at the end of the game to find all remaining sets on the board.
    //Method finishes when an empty set is returned, indicating all cards on the board have been scanned.
    private void findRemainingSets() {
        HashSet<Card> foundSet = (HashSet<Card>) findSet(board);
        while (!foundSet.isEmpty()){
            foundSets.add(foundSet);
            board.removeAll(foundSet);
            foundSet = (HashSet<Card>) findSet(board);
        }
    }

    //At the end of the game, iterate through and print all sets of valid cards.
    private void printFoundSets() {
        if (!gameOver){
            System.out.println("Game is now over. Please start game!");
        }else{
            int numberOfSets = foundSets.size();
            for (int i = 0; i < numberOfSets; i++){
                System.out.println("SET # " + (i + 1) + ": " + foundSets.get(i));
            }
        }
    }

    //Prints the board state at the end of the game.
    //Either remaining cards that do not form valid sets, or an empty board if all cards have been removed from board.
    private void printBoardState() {
        if (!gameOver){
            System.out.println("Game is now over. Please start game!");
        }else{
            System.out.println("Board state:");

            if (board.size() == 0){
                System.out.println("Board is empty!");
            }else{
                board.forEach(System.out::println);
            }
        }
    }

    //Adds 3 cards to the board each time a valid set is found, or when there are no valid sets on the board.
    //Checks to see if deck is empty before pulling additional cards. Pulls either 3 cards from deck or remaining cards.
    //There should never be a case where we pull from a deck with less than 3 cards.
    private void dealCards() {
        if (!deck.isEmpty()){
            for (int i = 0; i < 3 && i < deck.size(); i++){
                board.add(deck.pop());
            }
        }
    }

    //Initializes the board to have 12 initial cards.
    //There should never be a case where we're initializing a board when the deck has less than 12 cards.
    //Has additional checks to either pull 12 cards or rest of cards from deck.
    private void initializeBoard() {
        int deckSize = deck.size();
        if (!deck.isEmpty()){
            for (int i = 0; i < 12 && i < deckSize; i++){
                board.add(deck.pop());
            }
        }
    }

    //Returns all valid sets that were found and removed from the board throughout the game.
    public ArrayList<HashSet<Card>> getFoundSets(){
        return foundSets;
    }
}
