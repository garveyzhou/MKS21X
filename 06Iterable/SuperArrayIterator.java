import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray array;
    private int current;
	
    public SuperArrayIterator(SuperArray a, int start){
 	array = a;
 	current = start;
    }
	
    public boolean hasNext(){
	return current < array.size();
    }
	
    public String next(){
 	if(hasNext()){
 	    current++;
	}
	else{
 	    System.exit(1);
	}
	return array.get(current-1);
    }
	
    public void remove(){
	array.remove(array.get(current-1));
    }
}
