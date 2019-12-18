# FCIH_Parallel_Fall2019_prefix_sum_20160269
عمر فاروق عبد الواحد ابراهيم 20160269
علي خالد علي السيد  20160245
حسناء علاءالدين عبدالله 20160133


we do prefix sum in two algorithms :
first ---> serial_sum:
  we sum all prefix numbers to an index number by number.

second ---> parallel_sum:
  first determine a range (start - end) to calculate the prefix sum in that range 
  by dividing the length of the range on the number of available threads in the processor.
  then each thread sum patch_size of the all range 
  then sum all the results of the threads tasks to determine the prefix sum of the the range.
  
finally :
   we compare the time of excution in using sarial_sum and parallel_sum algorithms.



