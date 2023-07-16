public class tabelaHash {
    int size;
    tabelaHash[] vetor = new tabelaHash[10];

    public tabelaHash(){
        this.size = 0;
        this.vetor = new tabelaHash[10];
    }
    public void adicionar(String key, String valor){

    }
    public void remove(String key){

    }
    public String get(String key){
        return null;
    }
    public int getSize(){
        return this.size;
    }
    private void reHash(){

    }
    private int defineIndex(String key){
        int index = key.hashCode() % this.vetor.length;
        while(this.vetor[index] != null){
            if(index == vetor.length-1){
                index = 0;
            }else{
                index++;
            }
        } return index;
    }
}
