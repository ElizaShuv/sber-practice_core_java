package ru.sber.oop1.Task3;

public class MatrixTask {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}});
        Matrix matrix2 = new Matrix(new int[][]{{1, 1}, {2, 2},{1,1}});
        Matrix matrix3 = new Matrix(new int[][]{{3, 3}, {4, 4},{1,1}});

        System.out.println("Первая матрица:");
        matrix1.print();

        System.out.println("Вторая матрица:");
        matrix2.print();

        System.out.println("Третья матрица:");
        matrix3.print();

        System.out.println("Сумма первой и второй матрицы :");
        Matrix matrix4 = matrix1.MatrixSum(matrix2);
        matrix4.print();

        System.out.println("Сумма второй и третей матриц :");
        Matrix matrix5 = matrix2.MatrixSum(matrix3);
        matrix5.print();

        System.out.println("Умножение первой матрицы на число:");
        Matrix matrix6 = matrix1.MultiNum(matrix1,3);
        matrix6.print();

        System.out.println("Произведение первой и второй матрицы:");
        Matrix matrix7 = matrix1.MultiMatrix(matrix2);
        matrix7.print();
    }
}
