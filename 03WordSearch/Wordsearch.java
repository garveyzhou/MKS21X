import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Wordsearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;
    private int seed;
    private String key;

    public Wordsearch(int rows,int cols,String fileName){
	data = new char[rows][cols];
	for (int x = 0; x < rows; x++){
	    for (int y = 0; y < cols; y++){
		data[x][y]='_';
	    }
	}
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    wordsToAdd = new ArrayList<String>();
	    while (in.hasNext()){
		String word = in.nextLine();
		wordsToAdd.add(word);
	    }
	    in.close();
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
	randgen = new Random();
	seed = randgen.nextInt(1000);
	randgen = new Random(seed);
	addallWords();
	key = toString();
	System.out.println(wordsToAdd);
	System.out.println(wordsAdded);
	addletters();
	System.out.println(seed);
    }
    public Wordsearch(int rows,int cols,String fileName,int ranseed){
	data = new char[rows][cols];
	for (int x = 0; x < rows; x++){
	    for (int y = 0; y < cols; y++){
		data[x][y]='_';
	    }
	}
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    wordsToAdd = new ArrayList<String>();
	    while (in.hasNext()){
		String word = in.nextLine();
		wordsToAdd.add(word);
	    }
	    in.close();
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
	randgen = new Random();
	randgen = new Random(ranseed);
	addallWords();
	System.out.println(wordsToAdd);
	System.out.println(wordsAdded);
	key = toString();
	addletters();
    }


    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int x = 0; x <data.length;x++){
	    for(int i =0 ; i <data[i].length;i++){
		data[x][i]='_';
	    }
	}					   
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String s = "";
	for(int x = 0; x< data.length;x++){
	    for(int i = 0;i < data[x].length; i++){
		s += data[x][i]+ " ";
	    }
	    s += "\n";
	}
	return s;
    }

    public void key(){
	System.out.println(key);
    }
    
    private boolean addWord(int row,int col,String word,int rinc,int cinc){
	int len = word.length();
	if(rinc == 0 && cinc == 0){
	    return false;
	}
	for(int i = 0; i < word.length(); i ++){
	    
	    if(row > data.length || col > data[0].length || rinc * i + row >= data.length || cinc*i+col >=  data[0].length
	       || rinc * i + row < 0 || cinc*i+col < 0){  
		return false;
	    }
	}
	for(int x = 0;x < len;x++){
	    if(data[row+rinc*x][col+cinc*x] != '_'  && data[row+rinc*x][col+cinc*x] != word.charAt(x)){
		return false;
	    }
	}
	for(int x = 0 ;x<len;x++){
	    data[row+rinc*x][col+cinc*x] = word.charAt(x);
	}
	return true;
    }
    public boolean addallWords(){
	wordsAdded = new ArrayList<String>();
	int tries  = 1000;
	while(tries > 0){
	    if (wordsToAdd.size() == 0){
		return true;
	    }
	    if(addWord(randgen.nextInt(data.length),randgen.nextInt(data[0].length),
		       wordsToAdd.get(0),randgen.nextInt(3)-1,randgen.nextInt(3)-1)){
		wordsAdded.add(wordsToAdd.get(0));
		wordsToAdd.remove(wordsToAdd.get(0));
	    }
	}
	return true;
    }
    public void addletters(){
	String  alphabet = "abcdefghijklmnopqrstuvwxyz";
	for(int x = 0; x<data.length;x++){
	    for(int y = 0 ;y <data[x].length; y++){
		if(data[x][y] == '_'){
		    data[x][y] = alphabet.charAt(randgen.nextInt(26));
		}
	    }
	}
    }
    public static void main(String[] args){
	if(args.length < 3){
	    System.out.println("Enter <row><column><filename>");
	    System.out.println("Or <row><column><filename><randomseed>");
	    System.out.println("Or <row><column><filename><randomseed><answer>");
	}
	if(args.length == 3){
	    try{
		Wordsearch a = new Wordsearch (Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
		System.out.println(a.toString());
		System.exit(1);
	    }
	    catch (NumberFormatException e){
	        System.out.println("Enter a numerical row or column");
		System.exit(1);
	    }
	    catch (NegativeArraySizeException e){
		System.out.println("Enter a postive row or a positive column");
		System.exit(1);
	    }
	}
	if(args.length == 4){
	    try{
		Wordsearch a = new Wordsearch (Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		System.out.println(a.toString());
		System.exit(1);
	    }
	    catch (NumberFormatException e){
	        System.out.println("Enter a numerical row or column or seed");
		System.exit(1);
	    }
	    catch (NegativeArraySizeException e){
		System.out.println("Enter a postive row or a positive column or seed");
		System.exit(1);
	    }
	}
    	if(args.length == 5){
	    try{
		Wordsearch a = new Wordsearch (Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
		if(args[4].equals("key")) 
		   a.key();
		else{ System.out.println("enter key for answers");}
		System.exit(1);
	    }
	    catch (NumberFormatException e){
	        System.out.println("Enter a numerical row or column or seed");
		System.exit(1);
	    }
	    catch (NegativeArraySizeException e){
		System.out.println("Enter a postive row or a positive column or seed");
		System.exit(1);
	    }
	}
    }
}

