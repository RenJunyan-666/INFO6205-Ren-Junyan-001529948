package UF_HWQUPC_Client;

import edu.neu.coe.info6205.union_find.UF_HWQUPC;

import java.util.Random;
import java.util.Scanner;

public class UF_Alternative {

    private int[] parent;
    private int[] height;
    private int count;//the number of components

    public UF_Alternative(int n){
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    //quick-union find method
    private int find(int p){
        int root = p;

        while(root!=parent[root])
            root = parent[root];
        return root;
    }

    //alternative2--improve find method
    private int compression_QU(int p){

        int root = p;

        while(root != parent[root]){
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
    }

    //quick-union union method
    private void union(int p, int q){
        int i = compression_QU(p);
        int j = compression_QU(q);

        if(i == j)
            return;
        else {
            parent[i] = j;
            count--;
        }

    }

    //alternative1--improve union method
    private void weighted_QU(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;
        else {
            if(height[pID]<height[qID]){
                parent[pID] = qID;
                height[qID] += height[pID];
            }
            else {
                parent[qID] = pID;
                height[pID] += height[qID];
            }
            count--;
        }

    }

    //alternative1+alternative2--both of find and union methods are improved
    private void weighted_compression_QU(int p, int q){
        int pID = compression_QU(p);
        int qID = compression_QU(q);

        if(pID == qID)
            return;
        else {
            if(height[pID]<height[qID]){
                parent[pID] = qID;
                height[qID] += height[pID];
            }
            else {
                parent[qID] = pID;
                height[pID] += height[qID];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        //input size of sites
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input the size of sites:");
        int n = sc.nextInt();
        int mWQU = 0, mCQU = 0, mCWQU = 0;
        Random random = new Random();

        //weighted-QU
        UF_Alternative client1 = new UF_Alternative(n);
        do{
            //generate random pairs
            int m1 = random.nextInt(n);
            int m2 = random.nextInt(n);

            //connect random pairs
            client1.weighted_QU(m1,m2);
            mWQU++;

        }while (client1.count>1);

        System.out.println("weighted-QU's pairs generated is: "+mWQU);
        System.out.println();


        //compression-path-QU
        UF_Alternative client2 = new UF_Alternative(n);
        do{
            //generate random pairs
            int m1 = random.nextInt(n);
            int m2 = random.nextInt(n);

            //connect random pairs
            client2.union(m1,m2);
            mCQU++;
        }while (client2.count>1);

        System.out.println("compression-path-QU's pairs generated is: "+mCQU);
        System.out.println();

        //weighted-compression-path-QU
        UF_Alternative client3 = new UF_Alternative(n);
        do{
            //generate random pairs
            int m1 = random.nextInt(n);
            int m2 = random.nextInt(n);

            //connect random pairs
            client3.weighted_compression_QU(m1,m2);
            mCWQU++;
        }while (client3.count>1);

        System.out.println("weighted-compression-path-QU's pairs generated is: "+mCWQU);
        System.out.println();
    }

}
