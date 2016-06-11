package com.java.array;

/*
 * https://leetcode.com/problems/spiral-matrix-ii/
 * */
public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		
		int[][] resultMatrix = new int[n][n];
		if(n <= 0) {
			return resultMatrix;
		}
		
		int rowStart = 0, rowEnd = n-1;
		int columnStart = 0, columnEnd = n-1;
		int value = 1;
		while(rowStart <= rowEnd && columnStart <= columnEnd) {
			for(int i=columnStart; i<=columnEnd; i++) {
				resultMatrix[rowStart][i] = value++;
			}
			rowStart++;
			
			for(int i=rowStart; i<=rowEnd; i++) {
				resultMatrix[i][columnEnd] = value++;
			}
			columnEnd--;
			
			if(rowStart <= rowEnd) {
				for(int i=columnEnd; i>=columnStart; i--) {
					resultMatrix[rowEnd][i] = value++;
				}
				rowEnd--;
			}
			
			if(columnStart <= columnEnd) {
				for(int i=rowEnd; i>=rowStart; i--) {
					resultMatrix[i][columnStart] = value++;
				}
				columnStart++;
			}
		}
		return resultMatrix;
	}
}
