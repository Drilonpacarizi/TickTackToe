import java.util.Scanner;

public class TickTackToe {
    public static String x = "";
    public static String o = "";

    public static void matrica(int n){
        int [] m = new int[9];
        TickTackToe t = new TickTackToe();
        int player = 0;
        int comp = 0;

        print(m);
        for(int i = 0 ; i < m.length; i++){
            comp = t.kompInt();
            boolean b = kontrollo(m,comp);
            while(!b){
                comp = t.kompInt();
                b=kontrollo(m,comp);

            }
            if(b){
                m[comp]=1;
            }
            print(m);
            player = t.playerInt();
            b= kontrollo(m,player);
            while(!b){
                System.out.println("Vendi eshte i zene");
                player = t.playerInt();
                b=kontrollo(m,player);
            }
            if(b){
                m[player]=2;
            }
            print(m);
            if(kontrollofitusin(m)==0){
                //System.out.println("Barazim1");
               // break;
            }
            else{
                if(kontrollofitusin(m)==1){
                    System.out.println("Fiton kompjuteri");
                }
                else{
                    if(kontrollofitusin(m)==2){
                        System.out.println("Fiton Lojtari");
                    }
                }
                break;
            }
        }
    }
    public  int kompInt(){
        return  (int)(Math.random()*8);
    }
    public int playerInt(){
        Scanner s=new Scanner(System.in);
        int rez =s.nextInt();
        return  rez;
    }
    public static int kontrollofitusin(int[]m){
        int rez=0;
        for(int j=0;j<3;j++){
            if(m[0*3+j]==1 && m[1*3+j]==1 &&m[2*3+j]==1){
                rez=1;
            }
            if(m[0*3+j]==2 && m[1*3+j]==2 &&m[2*3+j]==2){
                rez=2;
            }
        }

        for (int i = 0; i < 3 ; i++) {
            if(m[3*i+0]==2 && m[3*i+1]==2 &&m[3*i+2]==2){
                rez=2;
            }
            if(m[3*i+0]==1 && m[3*i+1]==1 &&m[3*i+2]==1){
                rez=1;
            }
        }
        if(m[0]==m[4] &&m[4]==m[8] &&m[8]==1){
            rez=1;
        }
        if(m[0]==m[4] &&m[4]==m[8] &&m[8]==2){
            rez=2;
        }

        if(m[2]==m[4] &&m[4]==m[6] &&m[6]==1){
            rez=1;
        }
        if(m[0]==m[4] &&m[4]==m[8] &&m[8]==2){
            rez=2;
        }

        return rez;
    }
    public static boolean kontrollo(int [] m,int n){
        boolean answer = false;
        if(m[n]==0){
            answer = true;
        }
        return answer;
    }
    public static void print(int []a){
        int [][] m  = new int[3][3];
        for(int i = 0 ; i<m.length; i++){
            for(int j =0 ; j<m.length; j++){
                m[i][j]=a[i*3+j];
            }
        }
        for(int i = 0 ; i<m.length; i++){
            for(int j = 0 ; j < m.length; j++){
                if(m[i][j]==0)
                System.out.print(" [   ] ");
                else{
                    if(m[i][j]==1) {
                        x=m[i][j]+"X";
                        System.out.print(" [ " + x.substring(1,2) + " ] ");
                    }
                    else{
                        if(m[i][j]==2){
                            o=m[i][j]+"O";
                            System.out.print(" [ " + o.substring(1,2) + " ] ");
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        matrica(8);
    }
}
