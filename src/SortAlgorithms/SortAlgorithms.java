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
    

    public static void main(String[] args) {
        int[] array = {9,8,7,5,100,68,15,87,280,980,1555};

        SortAlgorithms.BubbleSort(array);

        for(int i = 0; i <= array.length - 1; i++){
            System.out.println(array[i]);
        }
    }
}