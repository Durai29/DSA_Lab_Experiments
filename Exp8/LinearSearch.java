package Exp8;

public class LinearSearch {
    public static boolean linearsearch(int arr[],int data){
        for(int a: arr){
            if(a==data){
                return true;
            }
        }
        return false;
    }
    public static void main(String arg[]){
        int [] arr = {1,2,3,4,5};
        if(linearsearch(arr,5)){
            System.out.println("Found");
        }else{
            System.out.println("Not found");
        }
    }
}
