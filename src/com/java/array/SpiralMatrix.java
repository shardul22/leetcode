package com.java.array;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/spiral-matrix/
 * */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return resultList;
        }

        int rowStart = 0, rowEnd = matrix.length - 1;
        int columnStart = 0, columnEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                resultList.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                resultList.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            if (rowStart <= rowEnd) {
                for (int i = columnEnd; i >= columnStart; i--) {
                    resultList.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    resultList.add(matrix[i][columnStart]);
                }
                columnStart++;
            }
        }
        return resultList;
    }

}
