package com.java.math;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		
		for(int i=0; i<board.length; i++) {
			if(!isValidBoard(i, i, 0, 8, board))
				return false;
			if(!isValidBoard(0, 8, i, i, board))
				return false;
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!isValidBoard(i*3, i*3 + 2, j*3, j*3 + 2, board))
					return false;
			}
		}
		
		return true;

	}
	
	public boolean isValidBoard(int rowStart, int rowEnd, int colStart, int colEnd, char[][] board) {
		Set<Character> boardElements = new HashSet<>();
		for(int i=rowStart; i<=rowEnd; i++) {
			for(int j=colStart; j<=colEnd; j++) {
				if(board[i][j] != '.' && !boardElements.add(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

}
