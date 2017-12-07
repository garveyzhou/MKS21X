import java.util.Array;
public class Sorts{
    public static boolean isSorted(int[]ary){                                   
        for(int i = 0; i < ary.length - 1 ; i++){                               
            if(ary[i] > ary[i+1]){                                              
                return false;                                                   
            }                                                                   
        }                                                                       
        return true;                                                            
    }
    private static void swap(int[]ary,int a, int b){                  
	int c =ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
    public static void SelectionSort(int [] ary){
	while(!isSorted(ary)){
	    int x = 0;
	    int min = ary[i];
	    int temp = 0;
	    for(int i = x; i < ary.length - 1; i++){
		min = ary[i];
		temp = i;
		if(min > ary[i+1]){
		    min = ary[i+1];
		    temp = i +1;
		}
	    }
	    swap(ary,x,temp);
	    x++;
	}
    }
}
    

	    
		   
