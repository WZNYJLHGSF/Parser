package Analysis;

public class Analysis_Table {
    String[][] Action_table_action = new String[16][8];
    int[][] Action_table_state = new int[16][8];
    int[][] goto_table = new int[16][3];
    public Analysis_Table(){



    }
    public void PrintTable(){
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tAction\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tgoto");
        System.out.println("状态  \t\t\t+\t\t\t\t -\t\t\t\t*\t\t\t\t/\t\t\t\t(\t\t\t\t)\t\t\t\tnum\t\t\t\t$\t\t\t\tE\t\t\t\tT\t\t\t\tF" );
        for (int i=0;i<16;i++){
            System.out.print(i+"\t\t\t\t");
            for(int j=0;j<8;j++){
                if(Action_table_action[i][j]=="ACC"){
                    System.out.print(Action_table_action[i][j] + "\t\t\t\t");
                }

                else if (Action_table_action[i][j] != "0") {
                    System.out.print(Action_table_action[i][j] +Action_table_state[i][j]+ "\t\t\t\t");

                } else {
                    System.out.print("  \t\t\t\t");
                }
            }
            for (int j=0;j<3;j++){
                if(goto_table[i][j]!=-1){
                    System.out.print(goto_table[i][j]+"\t\t\t\t");
                }
                else{
                    System.out.print("  \t\t\t\t");
                }
            }
            System.out.print("\n");
        }
    }

    public void setAction_table_action() {
        //               +                        -                              *                             /                            （                           ）                            num                         $
        Action_table_action[0][0]="E";Action_table_action[0][1]="E";Action_table_action[0][2]="E";Action_table_action[0][3]="E";Action_table_action[0][4]="S";Action_table_action[0][5]="E";Action_table_action[0][6]="S";Action_table_action[0][7]="E";
        Action_table_action[1][0]="S";Action_table_action[1][1]="S";Action_table_action[1][2]="E";Action_table_action[1][3]="E";Action_table_action[1][4]="E";Action_table_action[1][5]="E";Action_table_action[1][6]="E";Action_table_action[1][7]="ACC";
        Action_table_action[2][0]="R";Action_table_action[2][1]="R";Action_table_action[2][2]="S";Action_table_action[2][3]="S";Action_table_action[2][4]="R";Action_table_action[2][5]="R";Action_table_action[2][6]="R";Action_table_action[2][7]="R";
        Action_table_action[3][0]="R";Action_table_action[3][1]="R";Action_table_action[3][2]="R";Action_table_action[3][3]="R";Action_table_action[3][4]="R";Action_table_action[3][5]="R";Action_table_action[3][6]="R";Action_table_action[3][7]="R";
        Action_table_action[4][0]="E";Action_table_action[4][1]="E";Action_table_action[4][2]="E";Action_table_action[4][3]="E";Action_table_action[4][4]="S";Action_table_action[4][5]="E";Action_table_action[4][6]="S";Action_table_action[4][7]="E";
        Action_table_action[5][0]="R";Action_table_action[5][1]="R";Action_table_action[5][2]="R";Action_table_action[5][3]="R";Action_table_action[5][4]="R";Action_table_action[5][5]="R";Action_table_action[5][6]="R";Action_table_action[5][7]="R";
        Action_table_action[6][0]="E";Action_table_action[6][1]="E";Action_table_action[6][2]="E";Action_table_action[6][3]="E";Action_table_action[6][4]="S";Action_table_action[6][5]="E";Action_table_action[6][6]="S";Action_table_action[6][7]="E";
        Action_table_action[7][0]="E";Action_table_action[7][1]="E";Action_table_action[7][2]="E";Action_table_action[7][3]="E";Action_table_action[7][4]="S";Action_table_action[7][5]="E";Action_table_action[7][6]="S";Action_table_action[7][7]="E";
        Action_table_action[8][0]="E";Action_table_action[8][1]="E";Action_table_action[8][2]="E";Action_table_action[8][3]="E";Action_table_action[8][4]="S";Action_table_action[8][5]="E";Action_table_action[8][6]="S";Action_table_action[8][7]="E";
        Action_table_action[9][0]="E";Action_table_action[9][1]="E";Action_table_action[9][2]="E";Action_table_action[9][3]="E";Action_table_action[9][4]="S";Action_table_action[9][5]="E";Action_table_action[9][6]="S";Action_table_action[9][7]="E";
        Action_table_action[10][0]="S";Action_table_action[10][1]="S";Action_table_action[10][2]="E";Action_table_action[10][3]="E";Action_table_action[10][4]="E";Action_table_action[10][5]="S";Action_table_action[10][6]="E";Action_table_action[10][7]="E";
        Action_table_action[11][0]="R";Action_table_action[11][1]="R";Action_table_action[11][2]="S";Action_table_action[11][3]="S";Action_table_action[11][4]="R";Action_table_action[11][5]="R";Action_table_action[11][6]="R";Action_table_action[11][7]="R";
        Action_table_action[12][0]="R";Action_table_action[12][1]="R";Action_table_action[12][2]="S";Action_table_action[12][3]="S";Action_table_action[12][4]="R";Action_table_action[12][5]="R";Action_table_action[12][6]="R";Action_table_action[12][7]="R";
        Action_table_action[13][0]="R";Action_table_action[13][1]="R";Action_table_action[13][2]="R";Action_table_action[13][3]="R";Action_table_action[13][4]="R";Action_table_action[13][5]="R";Action_table_action[13][6]="R";Action_table_action[13][7]="R";
        Action_table_action[14][0]="R";Action_table_action[14][1]="R";Action_table_action[14][2]="R";Action_table_action[14][3]="R";Action_table_action[14][4]="R";Action_table_action[14][5]="R";Action_table_action[14][6]="R";Action_table_action[14][7]="R";
        Action_table_action[15][0]="R";Action_table_action[15][1]="R";Action_table_action[15][2]="R";Action_table_action[15][3]="R";Action_table_action[15][4]="R";Action_table_action[15][5]="R";Action_table_action[15][6]="R";Action_table_action[15][7]="R";



    }
    public void setAction_table_state() {
        //             +                        -                        *                           /                            （                      ）                          num                    $
        Action_table_state[0][0]=3;Action_table_state[0][1]=3;Action_table_state[0][2]=3;Action_table_state[0][3]=3;Action_table_state[0][4]=4;Action_table_state[0][5]=1;Action_table_state[0][6]=5;Action_table_state[0][7]=3;
        Action_table_state[1][0]=6;Action_table_state[1][1]=7;Action_table_state[1][2]=3;Action_table_state[1][3]=3;Action_table_state[1][4]=5;Action_table_state[1][5]=1;Action_table_state[1][6]=5;Action_table_state[1][7]=-1;
        Action_table_state[2][0]=3;Action_table_state[2][1]=3;Action_table_state[2][2]=8;Action_table_state[2][3]=9;Action_table_state[2][4]=3;Action_table_state[2][5]=3;Action_table_state[2][6]=3;Action_table_state[2][7]=3;
        Action_table_state[3][0]=6;Action_table_state[3][1]=6;Action_table_state[3][2]=6;Action_table_state[3][3]=6;Action_table_state[3][4]=6;Action_table_state[3][5]=6;Action_table_state[3][6]=6;Action_table_state[3][7]=6;
        Action_table_state[4][0]=3;Action_table_state[4][1]=3;Action_table_state[4][2]=3;Action_table_state[4][3]=3;Action_table_state[4][4]=4;Action_table_state[4][5]=3;Action_table_state[4][6]=5;Action_table_state[4][7]=4;
        Action_table_state[5][0]=8;Action_table_state[5][1]=8;Action_table_state[5][2]=8;Action_table_state[5][3]=8;Action_table_state[5][4]=8;Action_table_state[5][5]=8;Action_table_state[5][6]=8;Action_table_state[5][7]=8;
        Action_table_state[6][0]=3;Action_table_state[6][1]=3;Action_table_state[6][2]=3;Action_table_state[6][3]=3;Action_table_state[6][4]=4;Action_table_state[6][5]=1;Action_table_state[6][6]=5;Action_table_state[6][7]=3;
        Action_table_state[7][0]=3;Action_table_state[7][1]=3;Action_table_state[7][2]=3;Action_table_state[7][3]=3;Action_table_state[7][4]=4;Action_table_state[7][5]=1;Action_table_state[7][6]=5;Action_table_state[7][7]=3;
        Action_table_state[8][0]=3;Action_table_state[8][1]=3;Action_table_state[8][2]=3;Action_table_state[8][3]=3;Action_table_state[8][4]=4;Action_table_state[8][5]=1;Action_table_state[8][6]=5;Action_table_state[8][7]=3;
        Action_table_state[9][0]=3;Action_table_state[9][1]=3;Action_table_state[9][2]=3;Action_table_state[9][3]=3;Action_table_state[9][4]=4;Action_table_state[9][5]=1;Action_table_state[9][6]=5;Action_table_state[9][7]=3;
        Action_table_state[10][0]=6;Action_table_state[10][1]=7;Action_table_state[10][2]=3;Action_table_state[10][3]=3;Action_table_state[10][4]=5;Action_table_state[10][5]=15;Action_table_state[10][6]=5;Action_table_state[10][7]=2;
        Action_table_state[11][0]=1;Action_table_state[11][1]=1;Action_table_state[11][2]=8;Action_table_state[11][3]=9;Action_table_state[11][4]=1;Action_table_state[11][5]=1;Action_table_state[11][6]=1;Action_table_state[11][7]=1;
        Action_table_state[12][0]=2;Action_table_state[12][1]=2;Action_table_state[12][2]=8;Action_table_state[12][3]=9;Action_table_state[12][4]=2;Action_table_state[12][5]=2;Action_table_state[12][6]=2;Action_table_state[12][7]=2;
        Action_table_state[13][0]=4;Action_table_state[13][1]=4;Action_table_state[13][2]=4;Action_table_state[13][3]=4;Action_table_state[13][4]=4;Action_table_state[13][5]=4;Action_table_state[13][6]=4;Action_table_state[13][7]=4;
        Action_table_state[14][0]=5;Action_table_state[14][1]=5;Action_table_state[14][2]=5;Action_table_state[14][3]=5;Action_table_state[14][4]=5;Action_table_state[14][5]=5;Action_table_state[14][6]=5;Action_table_state[14][7]=5;
        Action_table_state[15][0]=7;Action_table_state[15][1]=7;Action_table_state[15][2]=7;Action_table_state[15][3]=7;Action_table_state[15][4]=7;Action_table_state[15][5]=7;Action_table_state[15][6]=7;Action_table_state[15][7]=7;




    }

    public void setGoto_table() {
        //        E                 T                   F                   E                   T                   F
        goto_table[0][0]=1;goto_table[0][1]=2;goto_table[0][2]=3;goto_table[8][0]=-1;goto_table[8][1]=-1;goto_table[8][2]=13;
        goto_table[1][0]=-1;goto_table[1][1]=-1;goto_table[1][2]=-1;goto_table[9][0]=-1;goto_table[9][1]=-1;goto_table[9][2]=14;
        goto_table[2][0]=-1;goto_table[2][1]=-1;goto_table[2][2]=-1;goto_table[10][0]=-1;goto_table[10][1]=-1;goto_table[10][2]=-1;
        goto_table[3][0]=-1;goto_table[3][1]=-1;goto_table[3][2]=-1;goto_table[11][0]=-1;goto_table[11][1]=-1;goto_table[11][2]=-1;
        goto_table[4][0]=10;goto_table[4][1]=2;goto_table[4][2]=3;goto_table[12][0]=-1;goto_table[12][1]=-1;goto_table[12][2]=-1;
        goto_table[5][0]=-1;goto_table[5][1]=-1;goto_table[5][2]=-1;goto_table[13][0]=-1;goto_table[13][1]=-1;goto_table[13][2]=-1;
        goto_table[6][0]=-1;goto_table[6][1]=11;goto_table[6][2]=3;goto_table[14][0]=-1;goto_table[14][1]=-1;goto_table[14][2]=-1;
        goto_table[7][0]=-1;goto_table[7][1]=12;goto_table[7][2]=3;goto_table[15][0]=-1;goto_table[15][1]=-1;goto_table[15][2]=-1;
        this.goto_table = goto_table;
    }

    public int getState(int q,int p,boolean isTerminator){
        if(isTerminator){//如果是终结符，则从Action_table表中查找
            if(Action_table_state[q][p]==0){//是否表中为空
                ERROR();//输出错误
            }
            else{
                return Action_table_state[q][p];//返回状态数
            }
        }
        else{//否则从goto_table表中查找
            if(goto_table[q][p]==-1){//是否表中为空
                ERROR();//输出错误
            }
            else {
                return goto_table[q][p];
            }
        }
        return -1;

    }
    public String getAction(int q,int p){

        if(Action_table_action[q][p]=="0"){//是否表中为空
            ERROR();//输出错误
        }
        else {
            return Action_table_action[q][p];//返回动作
        }
        return "-1";
    }
    public void ERROR(){//有错误
        System.out.println("ERROR!");
    }

}
