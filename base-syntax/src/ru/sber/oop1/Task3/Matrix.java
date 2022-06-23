package ru.sber.oop1.Task3;

public class Matrix {
    int[][] matrix;
    int rows;
    int columns;

    Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getValue(int row, int columns) {
        return matrix[row][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix MatrixSum (Matrix matrix) {
        if (rows == matrix.getRows() && columns == matrix.getColumns()) {
            Matrix res = new Matrix(matrix.getRows(), matrix.getColumns());
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    res.setValue(i, j, this.getValue(i, j) + matrix.getValue(i, j));
                }
            }
            return res;
        }
        else{
            System.out.println("Ошибка! Можно сложить только матрицы одинаковой размерности.");
            return new Matrix(0,0);
        }
    }

    public Matrix MultiNum(Matrix matrix, int num) {
        Matrix res = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                res.setValue(i,j,this.getValue(i,j) * num);
            }
        }
        return res;
    }

    public Matrix MultiMatrix(Matrix matrix) {
            Matrix res = new Matrix(rows, matrix.getColumns());
            if(columns == matrix.getRows()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <matrix.columns; j++) {
                    for (int k = 0; k < columns; k++) {
                        res.setValue(i, j, res.getValue(i, j) + this.getValue(i, k) * matrix.getValue(k, j));
                    }
                }
            }

            return res;
        }
        else{
            System.out.println("Ошибка! Такие матрицы нельзя перемножить");
            return new Matrix(0,0);
        }
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getValue(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
