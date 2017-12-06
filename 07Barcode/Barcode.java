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
    public String getBar(){
	return toBar(zip);
    }
    public int compareTo(Barcode a){
	return this.zip.compareTo(a.zip);
    }
	
    public boolean equals(Barcode a){
	return this.equals(a);
    }
    private static String convert(char x){
	String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	return s[Character.getNumericValue(x)];
    }
    public static String toBar(String z){
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
	String z ="";
	if (barcode.length() == 32){
	    if(barcode.charAt(0) == '|' && barcode.charAt(31) == '|'){
		String[] s = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		for( int x = 1; x < 27; x += 5){
		    for(int i = 0; i < 10 ; i ++){
			if(s[i].equals(barcode.substring(x,x+5))){
			    z += i;
			}
			throw new IllegalArgumentException();}
		}
	    }
	}
	else{throw new IllegalArgumentException();}
	return z;
    }
}
			   
