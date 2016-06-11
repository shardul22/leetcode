package com.java.math;

public class SudokuSolver {
	
	public void solveSudoku(char[][] board) {
        solve(board);
    }

	public boolean solve(char[][] board) {
		for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(board[i][j] == '.') {
        			for(char c='1'; c<='9'; c++) {
        				if(isValidBoard(i, j, c, board)) {
        					board[i][j] = c;
        					
        					if(solve(board)) {
        						return true;
        					}
        					else { 
        						board[i][j] = '.';
        					}
        				}
        			}
        			return false;
        		}
        	}
        }
		return true;
	}
	
	public boolean isValidBoard(int row, int column, char c, char[][] board) {
		for(int i=0; i<board.length; i++) {
			if(board[row][i] == c) {
				return false;
			}
			if(board[i][column] == c) {
				return false;
			}
		}
		for(int i=(row/3) *3; i<(row/3)*3 + 3; i++) {
			for(int j=(column/3) *3; j<(column/3)*3 + 3; j++) {
				if(board[i][j] == c)
					return false;
			}
		}
		return true;
	}
}
