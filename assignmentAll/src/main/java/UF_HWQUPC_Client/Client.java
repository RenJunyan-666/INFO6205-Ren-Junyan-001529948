package UF_HWQUPC_Client;

import edu.neu.coe.info6205.union_find.UF_HWQUPC;

import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int test = 0;//the number of tests
        Client tester = new Client();
        do{
            //input size of sites
            Scanner sc = new Scanner(System.in);
            System.out.print("Please input the size of sites:");
            int n = sc.nextInt();
            int m = 0;//the number of pairs
            int count = 0;//the number of connections

            //generate random pairs
            Random random = new Random();
            UF_HWQUPC client = new UF_HWQUPC(n,true);
            do{
                //generate random pairs
                int m1 = random.nextInt(n);
                int m2 = random.nextInt(n);

                //connect random pairs
                client.connect(m1,m2);

                //count the number of connections happening
                count += tester.count(m1,m2);

                //count the number of pairs
                m++;
            }while (client.count>1);

            System.out.println("the number of pairs is: "+m);
            System.out.println("the number of connections happening is: "+count);

            test++;
        }while(test<6);//6 test cases

    }

    public int count(int p, int q){
        int connection = (p==q)?0:1;
        return connection;
    }

}
