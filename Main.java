import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception { //главная
        Scanner in = new Scanner(System.in);
        System.out.println("Введите функцию");
        String a = in.nextLine();
        calc(a);

    }

//****************************************************************************************************

    public static String calc(String input) throws Exception {
        String in = input;
        int i=in.length();



//*********************************** Перевод в массив символов ***************************************

        char[] f= in.toCharArray();
        int k=0;
            for (char a : f) {
                if ((a == '+') || (a == '-') || (a == '*') || (a == '/')) {
                    k=k+1;
                }

                if (k>=2){
                    throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

                }
            }
        if (k==0){
            throw new Exception("//т.к. строка не является математической операцией");

        }

//****************************************************************************************************


        if (in.indexOf("+") >=0) {
            String[] sc = in.split("\\+");
            math(sc[0],sc[1],'+');
        }

        if (in.indexOf("-") >=0) {
            String[] sc = in.split("-");
            math(sc[0],sc[1],'-');
        }

        if (in.indexOf("/") >=0) {
            String[] sc = in.split("/");
            math(sc[0],sc[1],'/');
        }

        if (in.indexOf("*") >=0) {
            String[] sc = in.split("\\*");
            math(sc[0],sc[1],'*');
        }








//****************************************************************************************************

        if (i==0){
            System.out.println("Пустая строка");
        }







        return in;
        }


    public static String math(String input1, String input2, char s) throws Exception {

        String[] ri = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int i=0;
        int a1=0,a2=0;
        boolean e=false;
        for (String a:ri) {
            if (input1.compareTo(a) == 0) {
                a1 = i + 1;
                e=true;
            }
            if (input2.compareTo(a) == 0) {
                a2 = i + 1;
                e=true;
            }
            i = i + 1;

        }
        if ((a1 == 0 && a2 != 0) || (a1 != 0 && a2 == 0)) {
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        }


        if(a1==0){
            try {
                a1 = Integer.parseInt(input1);
                a2 = Integer.parseInt(input2);
            }
            catch (Exception p){
                throw new Exception("//т.к. числа не подходят исходным условиям от 0 до 10");
            }
        }
        int r=0;

        if((a1<1||a1>10)||(a2<1||a2>10)){
            throw new Exception("//т.к. числа не подходят исходным условиям от 0 до 10");
        }

        switch (s){
            case '*':
                r=a1*a2;
                break;

            case '/':
                r=a1/a2;
                break;

            case '+':
                r=a1+a2;
                break;

            case '-':
                r=a1-a2;
                break;
        }
        if (e==true && r<1){
            throw new Exception("//т.к. в римской системе нет отрицательных чисел");
        }
        String out;
        out=Integer.toString(r);

        if (e==true){
            char ou[] = new char[200];
            int l=0;
            for (int j=r;j>0;j=r){

                if (r>500){
                    r=r-500;
                    ou[l]='D';
                    l++;
                }
                if (r>100&&r<500){
                    r=r-100;
                    ou[l]='C';
                    l++;
                }
                if (r>90&&r<100){
                    r=r-90;
                    ou[l]='X';
                    l++;
                    ou[l]='C';
                    l++;

                }
                if (r>50&&r<100){
                    r=r-50;
                    ou[l]='L';
                    l++;
                }

                if (r>40&&r<50){
                    r=r-40;
                    ou[l]='X';
                    l++;
                    ou[l]='L';
                    l++;

                }
                if (r>30&&r<50&&ou[l-1]!='L'){
                    r=r-30;
                    ou[l]='X';
                    l++;
                    ou[l]='X';
                    l++;
                    ou[l]='L';
                    l++;

                }
                if (r>10&&r<50){
                    r=r-10;
                    ou[l]='X';
                    l++;
                }

                if(r<11){
                    out= new String(ou);
                    out=out.trim()+ri[r-1];
                    break;
                }


            }
        }


        System.out.println(out);

        return null;
    }
}


