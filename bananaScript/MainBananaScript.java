import java.util.*;

class MainBananaScript {

    static void print(String fmt, Object ...args) {
        System.out.print(String.format(fmt, args));
    }
    
    static void println(String fmt, Object ...args) {
        System.out.println(String.format(fmt, args));
    }

    static HashMap<String, Integer> vars = new HashMap<String,Integer>();
    
    static int allocate(String n) { 
	   if (vars.containsKey(n)) 
           return vars.get(n);
       int pos = vars.size()+1;
       vars.put(n,pos);
       return pos;
    }

    public static void main(String[] args) {
        System.out.println("Running as intended");
    }
}