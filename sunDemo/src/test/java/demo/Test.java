package demo;

/**
 * 测试
 *
 * @author sunchao
 * @create 2018/7/23
 */

public class Test {
    static int a;
    int b;
    static int c;

    public int aMethod() {
        a++;
        return a;
    }

    public int bMethod() {
        b++;
        return b;
    }

    public static int cMethod() {
        c++;
        return c;
    }

    public static void main(String args[]) {
        int month=16;
        int numbers = generateNumbers(month)+1;
        System.out.println("所有兔子为"+numbers+"对");
    }

    private static int generateNumbers(int n){
        if(n-7<0){
            return 0;
        }else if(n-7==0){
            return 1;
        }else {
            int num1 = (n-7)/3+1;
            return generateNumbers(n-7)+num1;
        }
    }


}