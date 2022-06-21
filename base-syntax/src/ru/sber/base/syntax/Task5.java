package ru.sber.base.syntax;

public class Task5 {
    public static void main(String[] args) {
        boolean PrimeNum;
        for( int num = 2; num<=100; num++){
            PrimeNum = true;
            for(int n = 2; n <= (Math.sqrt(num)+1);n++){
                if (num%n==0){
                    PrimeNum = false;
                    break;
                }
            }
          if (PrimeNum) System.out.print(num +" ");
        }
    }
}
