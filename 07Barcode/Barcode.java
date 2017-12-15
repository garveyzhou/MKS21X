import java.util.*;

public class Barcode implements Comparable<Barcode>{
    private String zip;
    public Barcode(String z){
	if (z.length() < 5 || z.length() >5){
	    throw new IllegalArgumentException();
	}
	for(int x = 0;x < 5; x++){
	    if(!(Character.isDigit(z.charAt(x)))){
	       throw new IllegalArgumentException();
	    }
	}
	zip = z;
    }
    public String getZip(){
	return zip;
    }
    public String toString(){
	return toCode(zip)+" "+zip;
    }
    public int compareTo(Barcode a){
	return this.zip.compareTo(a.zip);
    }
	
    private static String convert(char x){
	String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	return s[Character.getNumericValue(x)];
    }
    public static String toCode(String z){
	if (z.length() < 5 || z.length() >5){
	    throw new IllegalArgumentException();
	}
	for(int x = 0;x < 5; x++){
	    if(!(Character.isDigit(z.charAt(x)))){
		throw new IllegalArgumentException();
	    }
	}
	String bar = "|";
	for(int x =0; x < 5;x++){
	    bar += convert(z.charAt(x));
	}
	return bar+convert(checksum(z))+"|";
    }
    private static char checksum(String zip){
	int n = 0;
	for(int x =0; x < 5;x++){
	    n += Character.getNumericValue(zip.charAt(x));
	}
	String s = "" +n%10;
	return s.charAt(0);
    }
    public static String toZip(String barcode){
	String z ="";;
	if (barcode.length() == 32){
	    if(barcode.charAt(0) == '|' && barcode.charAt(31) == '|'){
		String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		for( int x = 1; x < 27; x += 5){
		    boolean add = false;
		    for(int i = 0; i < 10 ; i ++){
			if(s[i].equals(barcode.substring(x,x+5))){
			    z += i;
			    add =true;
			}
		    }
		    if (!add){
			throw new IllegalArgumentException();}
		}
	    }
	    else{throw new IllegalArgumentException();}
	}
	else{throw new IllegalArgumentException();}
	if(z.charAt(5) == checksum(z.substring(0,5))){
	    return z.substring(0,5);
	}
	else{throw new IllegalArgumentException();
	}
    }
    public static void main(String[] args){
	
	//Barcode e = new Barcode("asdfd"); //Contains non-barcode characters, should throw IllegalArgumentException
	//	Barcode f = new Barcode("1234"); //Invalid length, should throw IllegalArgumentException

	System.out.println(Barcode.toCode("00294")); // |||:::||:::::|:||:|:::|::|:|:|:|
	//System.out.println(Barcode.toCode("asdfd")); //Contains non-barcode characters, should throw IllegalArgumentException
	//System.out.println(Barcode.toCode("1234")); //Invalid length, should throw IllegalArgumentException
	System.out.println(Barcode.checksum("08451"));
		System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|")); //Should return 08451
		//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||:")); //Invalid length, should throw IllegalArgumentException
		//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||||")); //Incorrect checksum, should throw IllegalArgumentException
		// System.out.println(Barcode.toZip("|a::||:::||::|:|:|::|:|:|:::||:|")); //Contains non-barcode characters, should throw IllegalArgumentException
		//	System.out.println(Barcode.toZip("::::||:::||::|:|:|::|:|:|:::||:|")); //First character is not '|', should throw IllegalArgumentException
		//	System.out.println(Barcode.toZip("|:::||:::||::|:|:|::|:|:|:::||::")); //Last character is not '|', should throw IllegalArgumentException
		//	System.out.println(Barcode.toZip("|::::::::||::|:|:|::|:|:|:::||:|")); //Invalid character sequence, should throw IllegalArgumentException

    }
}
			   
