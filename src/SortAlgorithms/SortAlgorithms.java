package SortAlgorithms;

public class SortAlgorithms {
    public static void BubbleSort(int[] array){
        boolean troca;
        do{
            troca = false;
            for(int i = 0; i < array.length - 1; i++){
                if(array[i] > array[i+1]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    troca = true;
                }
            }
        }while(troca);
    }
    public static void mergeSort(int[] array){
        sort(array);
    }
    public static void sort(int[] array){
        if(array.length > 1){
            int leftSize = array.length / 2;
            int[] leftArray = new int[leftSize];
            for(int i=0; i<leftSize; i++){
                leftArray[i] = array[i];
            }

            int rightSize =  array.length - leftSize;
            int[] rightArray = new int[rightSize];

            for(int i=leftSize; i < array.length; i++){
                rightArray[i - leftSize] = array[i];
            }
            sort(leftArray);
            sort(rightArray);
            merge(leftArray, rightArray, array);
        }
    }
    public static void merge(int[] leftArray, int[] rightArray, int[] array){
        int left = 0;
        int right = 0;
        int vetor = 0;

        while(left < leftArray.length && right < rightArray.length){
            if(leftArray[left] <= rightArray[right]){
                array[vetor] = leftArray[left];
                vetor++;
                left++;
            }else{
                array[vetor] = rightArray[right];
                vetor++;
                right++;
            }
        }
        while (left < leftArray.length){
            array[vetor] = leftArray[left];
            vetor++;
            left++;
        }
        while(right < rightArray.length){
            array[vetor] = rightArray[right];
            vetor++;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println("BUBBLE SORT:");

        int[] array = {9,8,7,5,100,68,15,87,280,980,1555};
        SortAlgorithms.BubbleSort(array);
        for(int i = 0; i <= array.length - 1; i++){
            System.out.print(array[i] + " -- ");
        }
        System.out.println("");

        System.out.println("MERGE SORT:");
        int[] array2 = {9,8,7,5,100,68,15,87,280,980,1555};
        SortAlgorithms.mergeSort(array2);

        for(int i = 0; i <= array2.length - 1; i++){
            System.out.print(array[i] + " -- ");
        }
    }
}