public class OrderedSuperArray extends SuperArray{
    private int capacity;
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int start){
	super(start);
    }
    public OrderedSuperArray(String [] ary){
	super(ary.length);
	for(int x =0; x < ary.length; x++){
	    add(ary[x]);
	}
    }
    public void add (int index, String value){
	add(value);
    }
    public boolean add(String value){
	if (super.size() == 0){
	    super.add(0,value);
	    return true;
	}
	int s =super.size();
	for(int x = 0;x<s;x++){
	    if(value.compareTo(super.get(x)) <= 0){
		super.add(x,value);
	    }
	}
	return true;
    }
    private int findIndexBinary(String element){
	if (super.size() == 0){
	    return -1;
	}
	int start = 0;
	int end = super.size()-1;
	while(start != end){
	    int  mid = (start + end)/2;
	    if(super.get(mid).compareTo(element) == 0){
		end = mid ;
	    }
	    if(super.get(mid).compareTo(element) < 0){
		start = mid+1;
	    }
	    else{end = mid;}
	}
	return start;
    }
    public int indexOfBinary(String element){
	if (super.size() == 0){
	    return -1;
	}
	int start = 0;
	int end = super.size()-1;
	while(start != end){
	    int mid = (start + end)/2;
	    if(super.get(mid).compareTo(element) == 0){
		end = mid;
	    }
	    if(super.get(mid).compareTo(element)  < 0){
		start = mid+1;
	    }
	    else{end = mid;}
	}
	return start;
    }
    public int lastIndexOfBinary(String element){
	if (super.size() == 0){
	    return -1;
	}
	int start = 0;
	int end = super.size()-1;
	while(start != end){
	    int mid = (start + end)/2;
	    if(super.get(mid).compareTo(element) == 0){
		start = mid +1;
	    }
	    if(super.get(mid).compareTo(element) < 0){
		start = mid+1;
	    }
	    else{end = mid;}
	}
	return start;
    }
}
    
