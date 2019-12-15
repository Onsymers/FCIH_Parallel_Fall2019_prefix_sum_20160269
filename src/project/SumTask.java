/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author Onsymers
 */
public class SumTask implements Runnable{
    private int arr[];
    private long[] sums;
    private int start_idx;
    private int end_idx;
    private final CountDownLatch endController;
    private int thread_idx;
    
    public SumTask(int[] arr, long [] sums,int start_idx,int end_idx,int thread_idx, CountDownLatch endController){
        this.arr = arr;
        this.sums = sums;
        this.start_idx= start_idx;
        this.end_idx= end_idx;
        this.endController=endController;
        this.thread_idx=thread_idx;
        
                
    }

    @Override
    public void run() {
        long sum =0;
        
        for(int i=start_idx; i<end_idx; i++)
            sum +=arr[i];
        sums[thread_idx]=sum;
        
        endController.countDown();
    }
    
}
