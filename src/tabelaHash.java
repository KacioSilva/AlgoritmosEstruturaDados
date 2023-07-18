public class tabelaHash {
    private tabelaHashEntry[] vetor;
    private int sizeTable = 10;
    private int size;

    public tabelaHash(){
        this.vetor = new tabelaHashEntry[sizeTable];
        this.size = 0;
    }

    public void adicionar(String key, String value){
        if(this.size / this.sizeTable > 0.5){
            reHash();
        }else{
            int index = defineIndex(key);
            this.vetor[index] = new tabelaHashEntry(key, value);
            size++;
        }
    }
    private void reHash(){
        tabelaHashEntry[] newVetor = this.vetor;
        int newTableSize = this.sizeTable * 2;

        this.vetor = new tabelaHashEntry[newTableSize];
        this.sizeTable = newTableSize;

        for(tabelaHashEntry entry : newVetor){
            adicionar(entry.getKey(), entry.getValue());
        }
    }

    public int getSize(){
        return this.size;
    }
    public String get(String key){
        int index = defineIndex(key);
        return this.vetor[index] == null ? null : vetor[index].getValue();
    }

    private int defineIndex(String key){
        int hasCode = key.hashCode() < 0 ? key.hashCode() * (-1) : key.hashCode();
        int index = hasCode % vetor.length;
        while(vetor[index] != null && vetor[index].getKey() != key){
            if(index == vetor.length - 1){
                index = 0;
            }else{
                index++;
            }
        }return index;
    }
    
    public class tabelaHashEntry{
        private String key;
        private String value;

        public tabelaHashEntry(String key, String value){
            super();
            this.key = key;
            this.value = value;
        }
        public String getKey(){
            return this.key;
        }
        public void setKey(String key){
            this.key = key;
        }
        public String getValue(){
            return this.value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
}
