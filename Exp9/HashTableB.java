package Exp9;

public class HashTableB {
    private int size;
    private Integer table[];
    public HashTableB(int size){
        this.size = size;
        this.table = new Integer[size];
    }

    public int hashFunction(int key){
        return key % size;
    }
    
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(table[i]+" ");
        }
    }

    public void insert(int key){
        int index = hashFunction(key);
        int startIndex = index;
        while(table[index]!=null){
            index = (index+1) % size;
            if(index == startIndex){
                System.out.println("Table is Full");
                return;
            }
        }
        table[index] = key;
    }

    public void search(int key){
        int index = hashFunction(key);
        int startIndex = index;
        while(table[index]!=null){
            if(table[index].equals(key)){
                System.out.println("Found");
                return;
            }
            index = (index + 1) % size;
            if(index == startIndex){
                break;
            }
        }
        System.out.println("Not Found.");
    }

    public static void main(String arg[]){
        HashTableB table = new HashTableB(10);
        table.insert(2);
        table.insert(2);
        table.display();
        table.search(2);
    }
}
