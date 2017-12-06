public class Book{
    private String author;
    private String title;
    private String ISBN;
    public Book(){
    }
    public Book(String name,String t,String number){
	author = name;
	title = t;
	ISBN = number;
    }
    public String getauthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getno(){
	return ISBN;
    }
    public String toString(){
	return title+","+author+","+ISBN;
    }
}
