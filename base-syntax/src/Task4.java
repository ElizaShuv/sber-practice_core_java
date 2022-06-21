public class Task4 {
    public static void main(String[] args) {
        int n = 10;
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((float) Math.random());
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        float max = arr[0];
        float sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i]>max) max = arr[i];
            sum = sum + arr[i];
        }
        System.out.println("\nМаксимальное значение: " + max);
        System.out.println("Среднее значение: " + sum/n);
    }
}
