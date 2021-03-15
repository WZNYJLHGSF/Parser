package Analysis;

import java.util.ArrayList;
import java.util.List;

public class Grammar {
    List<String> Production = new ArrayList<>();//产生式
    List<String> Terminator = new ArrayList<String>();//终结符
    List<String> Nonterminal = new ArrayList<String>();//非终结符
    //List<String> FIRST = new ArrayList<String>();//FIRST集
    //List<String> FOLLOW = new ArrayList<String>();//FOLLOW集
    public Grammar(){
        //setProduction(Production);
        //setTerminator(Terminator);
        //setNonterminal(Nonterminal);

    }

    public void setProduction() {
        Production.add("S→E");//0
        Production.add( "E→E+T" );//1
        Production.add( "E→E-T" );//2
        Production.add( "E→T" );//3
        Production.add( "T→T*F" );//4
        Production.add( "T→T/F" );//5
        Production.add( "T→F" );//6
        Production.add( "F→(E)" );//7
        Production.add( "F→num" );//8
        System.out.println("文法的产生式为");
        for (int i = 0; i < Production.size(); i++) {
            System.out.println("("+i+") "+ Production.get(i));
        }
    }

    public void setTerminator() {
        Terminator.add("S");
        Terminator.add("E");
        Terminator.add("T");
        Terminator.add("F");
        System.out.print("产生式中终结符为：");
        for (int i = 0; i < Terminator.size(); i++) {
            System.out.print(Terminator.get(i) + " ");
        }
        System.out.print("\n");
    }

    public void setNonterminal() {
        Nonterminal.add("+");
        Nonterminal.add("-");
        Nonterminal.add("*");
        Nonterminal.add("/");
        Nonterminal.add("num");
        System.out.print("产生式中非终结符为：");
        for (int i = 0; i < Nonterminal.size(); i++) {
            System.out.print(Nonterminal.get(i) + " ");
        }
        System.out.print("\n");
    }

    public String getProduction(int i){
        return Production.get(i).toString();

    }


}
