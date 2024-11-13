package Exp9;

public class HashTable {
    private Integer[] table;
    private int size;

    public HashTable(int size){
        this.size = size;
        this.table = new Integer[size];
    }
    private int hashFunction(int key){
        return key % size;
    }
    public void insert(int key){
        int index = hashFunction(key);
        int startIndex = index;
        while(table[index]!=null){
            index = (index+1) % size;
            if(index == startIndex){
                System.out.println("HashTable is full.");
                return;
            }
        }
        table[index] = key;
    }
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(table[i]+" ");
        }
    }
    public boolean search(int key){
        int index = hashFunction(key);
        int startIndex = index;
        while(table[index]!=null){
            if(table[index].equals(key)){
                System.out.println("\nfound");
                return true;
            }
            index = (index+1) % size;
            if(index == startIndex){
                break;
            }
        }
        System.out.println("Not Found.");
        return false;
    }

    public static void main(String arg[]){
        HashTable table = new HashTable(10);
        table.insert(2);
        table.insert(2);
        table.display();
        table.search(2);
    }
}
