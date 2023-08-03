package Tabela_Hash;

public class testando {
    public static void bubbleTeste(int[] array){
        boolean troca;
        do{
            troca = false;
            for(int i = 0; i < array.length -1; i++){
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
                troca = true;
            }
        }while(troca);
    }
}