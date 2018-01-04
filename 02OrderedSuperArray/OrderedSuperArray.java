import java.util.*;
public class OrderedSuperArray extends SuperArray{
    private int capacity;
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int capacity){
	super(capacity);
    }
    public OrderedSuperArray(String [] ary){
	super(ary.length);
	for(int x =0; x < ary.length; x++){
	    add(ary[x]);
	}
    }
    
    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }
    
    public void add (int index, String value){
	add(value);
    }
    public boolean add(String value){
	int i = findIndexBinary(value);
	super.add(i,value);
	return true;
    }
    private int findIndexBinary(String s){
	if (size() == 0) {
	    return 0;
	}
	int start = 0;
	int end = size()-1;
	int mid;
	while (start != end) {
	    mid = (start + end) / 2;
	    if (get(mid).compareTo(s) <= 0) {
		start = mid + 1;
	    }
	    else {
		end = mid;
	    }
	}
	if (get(start).compareTo(s) <= 0) {
	    return start+1;
	}
	return start;
    }
    

    public int indexOfBinary(String element) {
	if (size() <= 0) {
	    return -1;
	}
	int start = 0;
	int end = size()-1;
	while (start != end) {
	    int mid = (start + end) / 2;
	    if (get(mid).compareTo(element) < 0) {
		start = mid + 1;
	    }
	    else {
		end = mid;
	    }
	}
	return start;
    }
 
    public int lastIndexOfBinary(String element){
	if (size() == 0){
	    return -1;
	}
	int start = 0;
	int end = size()-1;
	while(start != end){
	    int mid = (start + end)/2;
	    if(get(mid).compareTo(element) == 0){
		start = mid +1;
	    }
	    if(get(mid).compareTo(element) < 0){
		start = mid+1;
	    }
	    else{end = mid;}
	}
	return start;
    }
    public static void runTest02(int testID){
	
	if(testID<0){
	    System.out.println("Error in driver usage!");
	    System.exit(0);
	}
  
	OrderedSuperArray s1 = new OrderedSuperArray();
	ArrayList<String> s2 = new ArrayList<>();
  
	try{
	    if(testID == 0 ){
	    }
    
	    if(testID == 1 ){
		s1.add("4");
		s2.add("4");
		s1.add("1");
		s2.add("1");
		s1.add("0");
		s2.add("0");
	    }
    
	    if(testID == 2 ){
		s1.add("3");
		s2.add("3");
		s1.add("1");
		s2.add("1");
		s1.add("5");
		s2.add("5");
		s1.add("0");
		s2.add("0");
	    }
    
	    if(testID == 3 ){
		s1.add("1");
		s2.add("1");
		for(int i = 0; i < 10; i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
    
	    if(testID == 4 ){
		s1.add("1");
		s2.add("1");
		try{
		    s1.set(0,"");
		} catch(UnsupportedOperationException e){
        
		}
	    }
    
	    if(testID == 5 ){
		try{
		    s1.set(0,"");
		} catch(UnsupportedOperationException e){
        
		}
	    }
    
	    if(testID == 6 ){
		String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
		s1 = new OrderedSuperArray(x);
		s2.addAll(Arrays.asList(x));
	    }
	    if(testID == 7 ){
		s1.add("1");
		s2.add("1");
      
		for(int i = 0; i < 1000;   i ++){
		    String v = ""+(int)(Math.random()*1000);
		    s1.add(v);
		    s2.add(v);
		}
	    }
    
    
	}catch(Exception f){
	    s2.add("0");
	    //f.printStackTrace();
	}
  
	Collections.sort(s2);
	if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
	}else{
	    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
	}
	System.out.println(""+s1);
    }
    public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
	if(s.size() == a.size()){
	    for(int i = 0; i < s.size(); i++){
		if(!s.get(i).equals( a.get(i))){
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
    public static void main(String[] args){
	for(int i = 0; i < 8; i++){
	    runTest02(i);
	}
	OrderedSuperArray s1 = new OrderedSuperArray();
	s1.add("5");
	System.out.println(""+s1);
		s1.add("2");
	System.out.println(""+s1);
		s1.add("3");
	System.out.println(""+s1);
    }
}
    
