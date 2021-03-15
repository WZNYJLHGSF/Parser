package Analysis;

import java.util.Formatter;
import java.util.Scanner;
import java.util.Stack;

public class Analysis {
    String s ;//要识别的字符串
    int errornum = 0;
    Scanner scanner = new Scanner(System.in);
    Stack<Integer> State = new Stack<Integer>();//状态栈
    Stack<String> Symble = new Stack<String>();//符号栈
    int num = 0;//步骤数
    Grammar grammar = new Grammar();
    Analysis_Table analysis_table = new Analysis_Table();

    public Analysis(){
        grammar.setProduction();
        //grammar.setNonterminal();
        //grammar.setTerminator();
        analysis_table.setAction_table_action();
        analysis_table.setAction_table_state();
        analysis_table.setGoto_table();
        analysis_table.PrintTable();

        System.out.println("请输入需要识别的符号串：");


        s = scanner.next();
        System.out.println("          栈                                                  输入                      分析动作");
        s=s+"$";//加上结束标志
        State.push(0);
        Symble.push("-");

        //初始化状态栈和符号栈
        while(s.length()!=0) {
            //当前状态
            int now_state = State.peek();
            //当前指针指到的字符
            String now_s = getCurrentChar(s);
            //String now_s = String.valueOf(s.charAt(0));
            //当前字符在Action_table中的位置
            int m = getActionNum(now_s);
            //读取Action_table单元格中的第一个元素（S&R&0)

            String action = analysis_table.getAction(now_state, m);
            int new_state = analysis_table.getState(now_state,m,true);
            Print(action,new_state);
            if(now_state==1&&m==7){
                break;

            }
            switch (action) {
                case "S":
                    Shift(now_s,new_state);
                    //Print(action,new_state);
                    break;//移进
                case "R":
                    Reduce(new_state);
                    //Print(action,new_state);
                    break;//规约
                case "E":
                    Error(new_state);
                    break;
                default:
                    analysis_table.ERROR();
                    break;
            }

        }




    }
    public void Error(int n){
        if(n==1){//缺少'('    遇到')'直接忽略并移除
            System.out.println("括号不匹配");
            s=s.substring(1,s.length());

        }
        else if(n==2){//缺少')'   在字符末尾添加')'
            State.push(15);
            Symble.push(")");
            System.out.println("缺少')'");


        }
        else if(n==3){//缺少运算对象
            State.push(5);
            Symble.push("num");
            System.out.println("缺少运算对象");

        }
        else if(n==4){//	当状态4的时候遇上’$’   例如：)(
            Error(3);
            Error(2);

        }
        else if(n==5){//缺少运算符号
            //假设把一个'+'压入栈
            State.push(6);
            Symble.push("+");
            System.out.println("缺少运算符号");
        }
    }
    public void Shift(String new_symble,int new_state){//移进     new_state--新状态  new_symble--新符号
        State.push(new_state);
        Symble.push(new_symble);
        if(errornum>0){
            s=s.substring(errornum,s.length());
            errornum=0;
        }
        else {
            int r = new_symble.length();
            s = s.substring(r, s.length());
        }


    }
    public void Reduce(int state){//规约
        int r = grammar.getProduction(state).length()-2;
        if(state == 8)
            r=1;

        //弹出r个符号
        for(int i=0;i<r;i++){
            State.pop();
            Symble.pop();
        }

        //产生式的左边（非终结符号）
        String m = String.valueOf(grammar.getProduction(state).charAt(0));
        //将当前的符号压入栈
        Symble.push(m);
        int new_state = analysis_table.getState(State.peek(),getActionNum(m),false);
        //将当前的状态压入栈
        State.push(new_state);





    }
    public void Print(String action,int m){
        Formatter f1 = new Formatter(System.out);
        num++;
        System.out.print(num+"\t\t");

        //输出状态栈

        String state = State.toString();
        System.out.print("State: ");
        f1.format("%-25s", state);

        //输出输入
        f1.format("%25s", s);
        System.out.print("\t\t\t\t\t\t");
        //输出分析动作
        if(action == "S"){
            System.out.print("Shift "+m);
        }
        else if(action =="R"){
            System.out.print("reduce by "+grammar.getProduction(m));
        }
        else if(action == "ACC"){
            System.out.print("ACC");
        }

        System.out.print("\n");
        //输出符号栈
        String symble = Symble.toString();
        System.out.println("        Symble: "+symble);



    }

    public int getActionNum(String c){
        char a = c.charAt(0);
        if(a == '+')
            return 0;
        if(a == '-')
            return 1;
        if(a == '*')
            return 2;
        if(a == '/')
            return 3;
        if(c.compareTo("(")==0)
            return 4;
        if(c.compareTo(")")==0)
            return 5;
        if(c.compareTo("num")== 0)
            return 6;
        if(a == '$')
            return 7;
        if(a == 'E')
            return 0;
        if(a == 'T')
            return 1;
        if(a == 'F')
            return 2;

        if((a>='0'&&a<='9')||(a>='a'&&a<='z'))
            return 6;
        else
            return -1;
    }

    public String getCurrentChar(String a){
        String b=new String();
        char[] d = a.toCharArray();

        char c =d[0];
        if(c>='a'&&c<='z') {
            for (int i = 0; i < a.length(); i++) {
                c = d[i];
                if (c >= 'a' && c <= 'z' && c != '$') {
                    b = b + c;
                }
                else
                    break;
                if(b.compareTo("num")==0){

                    return b;
                }
                else if(b.contains("num")){//当b中已经包含num时停止
                    if(b.length()!=3) {
                        errornum = b.length();
                        System.out.println("num输入错误");
                    }
                    return b;
                }

            }
        }

        else if(b.isEmpty()){//符号
            b = b+c;
            return b;
        }

            System.out.println("num输入错误！");
            errornum=b.length();
            return "num";



        /*else{
            System.out.println("num输入错误！");
            errornum=b.length();
            return "num";
        }*/



    }



}
