import java.util.Arrays;
public class Sorts{
    public static String name(){
	return "10.Zhou.Garvey";
    }
    
    public static boolean isSorted(int[]ary){                                   
        for(int i = 0; i < ary.length - 1 ; i++){                               
            if(ary[i] > ary[i+1]){                                              
                return false;                                                   
            }                                                                   
        }                                                                       
        return true;                                                            
    }
    
    public static void bogoSort(int[]ary){
	while(!isSorted(ary)){
	    for (int i = 0; i < ary.length; i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i] = ary[newSpot];
		ary[newSpot] = temp;		    
	    }
	}
    }
    
    private static void swap(int[]ary,int a, int b){                  
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
    public static void selectionSort(int [] ary){
	for(int x = 0 ; x < ary.length; x++){
	    int min = ary[x];
	    int temp = x;
	    for(int i = x; i < ary.length - 1; i++){
		if(min > ary[i+1]){
		    min = ary[i+1];
		    temp = i +1;
		}
	    }
	    swap(ary,x,temp);
	}
    }
    public static void insertionSort(int[] ary){
	for(int i = 1; i < ary.length; i ++){
	    int temp = ary[i];
	    int index = i;
	    for(int x = i; x > 0 && ary[x-1] > temp;x --){
		swap(ary,x,x-1);
	    }
	}
    }
    public static void bubbleSort(int[] ary){
	boolean NOswap = false;
	int end = ary.length;
	while(!NOswap){
	    int swapcount = 0;
	    for (int x = 0; x < end-1;x++){
		if(ary[x] > ary[x+1]){
		    swap(ary,x,x+1);
		    NOswap = false;
		    swapcount += 1;
		}
	    }
	    if( swapcount == 0){
		NOswap = true;
	    }
	    end --;
	}
    }
	    
    public static void main(String[] args){
	int[] ary = new int[10];
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random()*100);
	}
	System.out.println(Arrays.toString(ary));
	bubbleSort(ary);
	System.out.println(Arrays.toString(ary));
    }
}
    
