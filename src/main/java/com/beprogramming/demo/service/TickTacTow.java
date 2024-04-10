package com.beprogramming.demo.service;

public class TickTacTow {
    public Player[] getBoard() {
        return board;
    }

    private Player[] board = new Player[9];

    private final String[] combinations = {
            "012",
            "345",
            "678",
            "036",
            "147",
            "258",
            "048",
            "246"
    };

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private Player currentPlayer = Player.X;

    public Player play(int x, Player p) {
        if (board[x] == null) {
            board[x] = p;
            if (currentPlayer == Player.O)
                currentPlayer = Player.X;
            else
                currentPlayer = Player.O;
        }

        if (checkForDraw())
            return null;
        return checkForWinner();
    }

    public boolean checkForDraw() {
        for (int i = 0;i < board.length;i++) {
            if (board[i] == null)
                return false;
        }
        return true;
    }

    public Player checkForWinner() {

        for (int i = 0; i < combinations.length;i++) {
            Player winner = checkForWinner(combinations[i]);
            if (winner != null)
                return winner;
        }
        return null;
    }

    public Player checkForWinner(String combinations) {
        Player currentPlayer = null;
        for (int j = 0;j < combinations.length();j++) {
            Player c = getBoardPiece(Integer.parseInt(Character.toString(combinations.charAt(j))));
            if (c == null) {
                return null;
            }
            if (currentPlayer == null)
                currentPlayer = c;
            if (currentPlayer != c)
                return null;

        }
        return currentPlayer;
    }

    private Player getBoardPiece(int x, int y){
        return board[x*3+y];
    }

    private Player getBoardPiece(int x){
        return board[x];
    }
}
