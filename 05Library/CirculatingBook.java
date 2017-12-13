public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author,title,ISBN,callNumber);
	currentHolder = null;
	dueDate = null;
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getdueDate(){
	return dueDate;
    }
    public void setCurrentHolder(String patron){
	currentHolder = patron;
    }
    public void setdueDate(String date){
	dueDate = date;
    }
    public void checkout(String patron,String date){
	setCurrentHolder(patron);
	setdueDate(date);
    }
    public void returned(){
	setCurrentHolder(null);
	setdueDate(null);
    }
    public String circulationStatus(){
	if( currentHolder == null && dueDate == null){
	    return "Book is available";
	}
	else{return getCurrentHolder() +","+ getdueDate();}
    }
    public String toString(){
	if( currentHolder == null && dueDate == null){
	    return super.toString();
	}
	else{return super.toString() +"," +getCurrentHolder()+","+getdueDate();}
    }
}

		
