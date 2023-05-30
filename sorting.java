
import java.util.Arrays;

public class sorting {

    public static int[] merge(int[] array,int[] array2){
        int index = 0;
        int[] combined = new int[array.length + array2.length];
        int i = 0;
        int j = 0;
        while(i < array.length && j < array2.length){
            if(array[i]<array2[j]){
                combined[index] = array[i];
                i++;
                index++;
            }
            else{
                combined[index] = array2[j];
                j++;
                index++;
            }
        }
        while(i < array.length){
            combined[index] = array[i];
            i++;
            index++;
        }
        while(j < array2.length){
            combined[index] = array2[j];
            j++;
            index++;
        }
        return combined;

    }

    public static int[] mergesort(int[] array){
        if(array.length == 1) return array;

        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);

        return merge(mergesort(left),mergesort(right));

    }

    public static void bubblesort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void selectionsort(int[] array){
        for(int i=0; i<array.length;i++){
            int minindex = i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minindex]){
                    minindex = j;
                }
            }
            if(i != minindex){
                int temp = array[i];
                array[i] = array[minindex];
                array[minindex] = temp;
            }
        }
    }

    public static void insertionsort(int[] array){
        for(int i=1; i<array.length;i++){
            int temp = array[i];
            int j = i-1;
            while(j > -1 && temp < array[j]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,6,1,2};
        
        // bubblesort(array);
        // selectionsort(array);
        // insertionsort(array);
        // mergesort(array);
        System.out.println(Arrays.toString(mergesort(array)));

    }
}
