public class ReversedCharSeq implements CharSequence{
    private String seq;
    public ReversedCharSeq(String seq){
	String res = "";
	seq = "";
	for (int i = seq.length()-1;i >= 0; i --){
	    res += seq.charAt(i);
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
	return seq;
    }
    public String toString(){
	return seq;
    }
    public static void main(String[] args){
	ReversedCharSeq a = new ReversedCharSeq("DONUTS");
	System.out.println(a.toString());
    }
}
