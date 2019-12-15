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
public class Prefixsum {
    
    private int [] arr;
    private int size;
    private int start;
    private int end;
    private long sum;
    
    
    private ThreadPoolExecutor executor;
    private int numThreads;
    
    
    
    public Prefixsum(int [] arr, int size){
        this.arr=arr;
        this.size=size;
        
    }
    
    public long serial_sum(int start, int end ){
        sum = 0;
        
        for(int i=start;i<end; i++)
            sum += this.arr[i];
        
        return sum;
    }
    
    public long Parallel_sum(int start, int end,int factor) throws InterruptedException{
        
        long [] sums=new long [20];
        sum = 0;
        
        numThreads=factor* (Runtime.getRuntime().availableProcessors());
        
        executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(numThreads);
        CountDownLatch endController = new CountDownLatch(numThreads);
        int lenght=end-start;
        
        int patches_size = lenght/numThreads;
        int local_start=start,local_end=start+patches_size;
        
        for(int i=0;i<numThreads;i++){
            
            SumTask task = new SumTask(arr, sums, local_start, local_end,i, endController);
            
            local_start = local_end;
            if(i < numThreads-2)
                local_end +=patches_size;
                
            else
                local_end = end;
            
            executor.execute(task);
        }
        
        endController.await();
        
        
        for(long x:sums)
            sum += x;
        
        return sum;
        
    }
    
    public void destroy() {
        executor.shutdown();
    }
    
    
}
