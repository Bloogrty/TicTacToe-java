


	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Scanner;

	public class TicTacToe {
	    private static final List<String> rowOne = new ArrayList<>(Arrays.asList("_", "_", "_"));
	    private static final List<String> rowTwo = new ArrayList<>(Arrays.asList("_", "_", "_"));
	    private static final List<String> rowThree = new ArrayList<>(Arrays.asList("_", "_", "_"));

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Hello, welcome to TicTacToe!");
	        System.out.print("How many matches would you like?: ");
	        int matches = tryParseInt(scanner.nextLine());
	        startGame(matches, scanner);
	    }

	    private static void startGame(int matches, Scanner scanner) {
	        for (int i = 0; i < matches; i++) {
	            while (!checkIfPlayerWin("X") && !checkIfPlayerWin("O")) {

	                printBoard();
	                System.out.print("Player 1, what move would you like to do? (ex: A1, C2, etc.): ");
	                String moveX = scanner.nextLine();
	                parseMove(moveX, "X");
	                if (checkIfPlayerWin("X")) {
	                    System.out.println("Player one wins!");
	                    return;
	                }

	                // print whitespace to clear up console.
	                System.out.println();
	                System.out.println();
	                System.out.println();

	                printBoard();
	                System.out.print("Player 2, what move would you like to do? (ex: A1, C2, etc.): ");
	                String moveO = scanner.nextLine();
	                parseMove(moveO, "O");
	                if (checkIfPlayerWin("O")) {
	                    System.out.println("Player two wins!");
	                    return;
	                }
	                printBoard();
	                if (!rowOne.contains("_") && !rowTwo.contains("_") && !rowThree.contains("_")) {
	                    System.out.println("It's a draw!");
	                    return;
	                }
	            }

	            printBoard();
	            System.out.println();
	            System.out.println("A player has won!");

	        }
	    }

	    private static boolean checkIfPlayerWin(String player) {
	        if (rowOne.get(0).equals(player) && rowOne.get(1).equals(player) && rowOne.get(2).equals(player)) {
	            return true;
	        } else if (rowTwo.get(0).equals(player) && rowTwo.get(1).equals(player) && rowTwo.get(2).equals(player)) {
	            return true;
	        } else if (rowThree.get(0).equals(player) && rowThree.get(1).equals(player) && rowThree.get(2).equals(player)) {
	            return true;
	        } else if (rowOne.get(0).equals(player) && rowTwo.get(0).equals(player) && rowThree.get(0).equals(player)) {
	            return true;
	        } else if (rowOne.get(1).equals(player) && rowTwo.get(1).equals(player) && rowThree.get(1).equals(player)) {
	            return true;
	        } else if (rowOne.get(2).equals(player) && rowTwo.get(2).equals(player) && rowThree.get(2).equals(player)) {
	            return true;
	        } else if (rowOne.get(0).equals(player) && rowTwo.get(1).equals(player) && rowThree.get(2).equals(player)) {
	            return true;
	        } else if (rowOne.get(2).equals(player) && rowThree.get(1).equals(player) && rowThree.get(0).equals(player)) {
	            return true;
	        }
	        return false;
	    }

	    private static void parseMove(String move, String playerTurn) {
	        switch (move) {
	            case "A1":
	                rowOne.set(0, playerTurn);
	                break;
	            case "B1":
	                rowOne.set(1, playerTurn);
	                break;
	            case "C1":
	                rowOne.set(2, playerTurn);
	                break;
	            case "A2":
	                rowTwo.set(0, playerTurn);
	                break;
	            case "B2":
	                rowTwo.set(1, playerTurn);
	                break;
	            case "C2":
	                rowTwo.set(2, playerTurn);
	                break;
	            case "A3":
	                rowThree.set(0, playerTurn);
	                break;
	            case "B3":
	                rowThree.set(1, playerTurn);
	                break;
	            case "C3":
	                rowThree.set(2, playerTurn);
	                break;
	        }
	    }


	    private static void printBoard() {
	        System.out.println(" A  B  C");
	        System.out.println(" --------");
	        printBoardHelper();
	        System.out.println(" --------");
	    }

	    private static void printBoardHelper() {

	        System.out.print("1 |");
	        for (String value : rowOne) {
	            System.out.print(value + "|");
	        }
	        System.out.println();

	        System.out.print("2 |");
	        for (String value : rowTwo) {
	            System.out.print(value + "|");
	        }
	        System.out.println();

	        System.out.print("3 |");
	        for (String value : rowThree) {
	            System.out.print(value + "|");
	        }
	        System.out.println();
	    }


	    private static int tryParseInt(String input) {
	        try {
	            return Integer.parseInt(input);

	        } catch (Exception e) {
	            // -999 is error code.
	            return -999;
	        }
	    }
	}