public class ReversedCharSequence implements CharSequence{
    private String seq;
    public ReversedCharSequence(String str){
	String res = "";
	for (int i = str.length()-1;i >= 0; i --){
	    res += str.charAt(i);
	}
	seq = res;
    }
    public char charAt(int index){
	return seq.charAt(index);
    }
    public int length(){
	return seq.length();
    }
    public CharSequence subSequence(int start, int end){
	String s ="";
	for(int i = start;i < end -1; i++){
	    s += this.seq.charAt(i);
	};
	return s;
    }
    public String toString(){
	return seq;
    }
    public static void main(String[] args){
	ReversedCharSequence a = new ReversedCharSequence("DONUTS");
	System.out.println(a.toString());
	System.out.println(a.subSequence(0,5));
    }
}
