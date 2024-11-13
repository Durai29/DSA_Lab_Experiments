package Exp8;

public class BinarySearch {
    public static int binarySearch(int arr[], int data){
        int left = 0;
        int right = arr.length - 1;

        while(left<=right){
            int mid = left + (right-left) / 2;
            if(arr[mid]==data){
                return mid;
            }
            if(arr[mid]<data){
                left = mid + 1;
            }else{
                right = mid - 1; 
            }
        }
        return -1;
    }

    public static void main(String arg[]){
        int arr [] = {1,2,3,4,5,6,7,8,9,10};
        if(binarySearch(arr,9)!=-1){
            System.out.println("Found. "+binarySearch(arr, 9));
        }else{
            System.out.println("Not Found.");
        }
    }
}
