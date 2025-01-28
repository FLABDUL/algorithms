package algorithms.practise;

public class SelectionSortPractice {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        //outer loop
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            // find min, assuming first smallest and update
            for(int j=i+1; j<n; j++){
                if (arr[j] < arr[minIndex]) { // Compare the current element with the current minimum
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            //swap
            if(minIndex!= i){
                int temp = arr[minIndex];
                arr[minIndex] =arr[i];
                arr[i] = temp;
            }
        }





        //swap in with first
    }
}
