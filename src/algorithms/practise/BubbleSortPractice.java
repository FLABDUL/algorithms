package algorithms.practise;

public class BubbleSortPractice {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        bubbleSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        //traverse all elements
        for(int i=0; i<n; i++){
            swapped = false;

            //inner loop comparison and swap with check
            for(int j=0; j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }

            }
            //break if already swapped
            if(!swapped) break;

        }


    }
}
