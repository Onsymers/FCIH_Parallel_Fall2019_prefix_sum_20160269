/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Time;
import java.util.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Onsymers
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        int a_size=100000000;
        
        System.out.println(a_size);
        int [] arr= new int[a_size];
        ArrayList<Long> x = new ArrayList<>();
        
        
        for(int i=0; i<a_size ;i++)
            arr[i]=i;
        
        Prefixsum PFsum= new Prefixsum(arr, a_size);
        
        int start=0,end=101;
        
        long sum;
        long startTime;
        int j=0;
        for(int i = 10; i <=a_size; i*=10){
            j++;
            System.out.println("Lenght = 10x"+j);
            startTime= System.nanoTime();
            sum = PFsum.serial_sum(start, i);

            System.out.println("Sum of serial = "+sum);
            System.out.println("Time of serial = "+(System.nanoTime()-startTime));


            startTime= System.nanoTime();
            sum = PFsum.Parallel_sum(start, i, 1);
            PFsum.destroy();

            System.out.println("Sum of Parallel = "+sum);
            System.out.println("Time of Parellel = "+(System.nanoTime()-startTime)+"\n");
        
        }
        
        
        
        
        
        
        
        
        
    }
    
}
