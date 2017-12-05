public class SuperArray{
    private int size;
    private String[] data;
    private int start;
    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    public SuperArray(int start){
	data = new String[start];
	size = 0;
    }	
    public void clear(){
	data = new String[data.length];
	size = 0;
    }
    public int size(){
	return size;
    }
    public boolean isEmpty(){
	return size == 0;
    }
    public boolean add(String element){
	if(size >= data.length){
	    resize();
	}
	data[size] = element;
	size += 1;
	return true;
    }
    public String toString(){
	String res ="["+data[0];
	for(int x = 1; x < size;x++){
	    res += "," +  data[x];
	}
	return res += "]";
    }
    public String get(int index){
	return data[index];
    }
    public String set(int index,String element){
	if(index < data.length ||  index >= 0){
	    String old = data[index];
	    data[index] = element;
	    return old;}

    private void resize(){
	String[] newdata = new String[data.length*2+1];
	for (int x = 0;x<data.length;x++){
	    newdata[x] = data[x];
	}
        data = newdata;
    }
    public String[] getData(){
	return data;
    }
    public boolean contains(String target){
	for(int i = 0;i < data.length ; i++){
	    if (data[i].equals(target)){
		return true;
	    }
	}
	return false;
    }
    public int indexOf(String element){
	for(int i =0; i < data.length ; i ++){
	    if (data[i].equals(element) ){
		return i;
	    }
	}
	return -1;
    }
    public int LastindexOf(String element){
	for ( int i = data.length-1; i >= 0;i -= 1){
	    if (data[i].equals(element)){
		return i;
	    }
	}
	return -1;
    }
    public void add(int index, String element){
	int x  = size;
	if (size >=  data.length){
	    System.out.println("Error,Index OutofBounds");
	}
	else{while(x != index){
		data[x] = data[x-1];
		x -= 1;
	    }
	    data[x] = element;
	    size += 1;
	}
    }
    public String remove(int x){
	if (x > data.length ||  x < 0){
	    System.out.println("Error,Index OutOfBounds");
	    return "null";
	}
	String removed = "";
	String[] newdata = new String[data.length];
	for (int i = 0;i < data.length;i += 1){
	    if(i == x){
		removed += data[i];
	    }
	    if(i != x){
		newdata[i] = data[i];
	    }
	}
	data = newdata;
	return removed;
    }
    public boolean remove(String str){
	if(this.contains(str)){
	    remove(indexOf(str));
	    return true;
	}
	return false;}
}
