public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String author,String title,String ISBN,String callNumber,String collection){
	super(author,title,ISBN,callNumber);
	this.collection = collection;
    }
    public String getCollection(){
	return collection;
    }
    public void setCollection(){
	this.collection = collection;
    }
    public void checkout(String patron,String dueDate){
	System.out.println("cannot check out a reference book");
    }
    public void returned(){
	System.out.println("reference book could not have been checked out");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString() + "," + getCollection();
    }
}
