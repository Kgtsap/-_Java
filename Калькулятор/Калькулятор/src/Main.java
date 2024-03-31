import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    private static HashMap<String, Integer> StrToNum=new HashMap<String, Integer>(){
        {
            put("I",1);
            put("II",2);
            put("III",3);
            put("IV",4);
            put("V",5);
            put("VI",6);
            put("VII",7);
            put("VIII",8);
            put("IX",9);
            put("X",10);
            put("1",1);
            put("2",2);
            put("3",3);
            put("4",4);
            put("5",5);
            put("6",6);
            put("7",7);
            put("8",8);
            put("9",9);
            put("10",10);
        }
    };
    private static HashMap<Integer, String> NumToRome=new HashMap<Integer, String>(){
        {
            put(100, "C");
            put(90, "XC");
            put(80, "LXXX");
            put(70, "LXX");
            put(60, "LX");
            put(50, "L");
            put(40, "XL");
            put(30, "XXX");
            put(20, "XX");
            put(10, "X");
            put(9, "IX");
            put(8, "VIII");
            put(7, "VII");
            put(6, "VI");
            put(5, "V");
            put(4, "IV");
            put(3, "III");
            put(2, "II");
            put(1, "I");
            put(0, "");
        }
    };



    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));

    }


    public static String calc(String input) throws Exception {

        String[] exp=input.split(" ");
        if(exp.length!=3) throw new Exception();

        if(Character.isLetter((char)(exp[0].charAt(0)))!=Character.isLetter((char)(exp[2].charAt(0)))) throw new Exception();
        if(!StrToNum.containsKey(exp[0]) || !StrToNum.containsKey(exp[2]))  throw new Exception();
        char type='A';
        if (Character.isLetter((char)(exp[0].charAt(0)))) type='R';
        int res=0;
        switch (exp[1]){
            case "+":
                res=StrToNum.get(exp[0])+StrToNum.get(exp[2]);
                break;
            case "-":
                res=StrToNum.get(exp[0])-StrToNum.get(exp[2]);
                break;
            case "*":
                res=StrToNum.get(exp[0])*StrToNum.get(exp[2]);
                break;
            case "/":
                res=StrToNum.get(exp[0])/StrToNum.get(exp[2]);
                break;
            default:
                throw new Exception();
        }

        if(res<=0 && type=='R') throw new Exception();
        if(type=='A') return Integer.toString(res);
        if(NumToRome.containsKey(res)) return NumToRome.get(res);
        return NumToRome.get(res/10*10)+NumToRome.get(res%10);
    }

}