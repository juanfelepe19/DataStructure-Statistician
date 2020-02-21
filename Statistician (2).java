class Statistician extends OrderedList{
   
   public double sum(){
      double sum=0;
      for(int i=0; i<count; i++){
         sum+=items[i];
      }
      return sum;
   }
   
   public double largest(){
      double max=items[0];
      for(int i=1; i<count; i++){
         if(items[i]>max)
         max = items[i];
      }
      return max;
   }
   
   public double smallest(){
      double min=items[0];
      for(int i=1; i<count; i++){
         if(items[i]<min)
         min = items[i];
      }
      return min;
   }  
   
   public double mean(){
      return sum()/count;
   }
   
   public double median(){
      int median=0;
      double value=0;
      if(count%2==0){
         median = count/2;
         value = items[median-1]+items[median];
         value/=2;
      }
      else{
         median = count/2;
         value = items[median];
      }
         
      return value;
   }
   public void mode(){
      int mode[] = new int[count];
      int c=0;
      int appear=0;
      int b=0;
      for(int i=0; i<count; i++){
         c=0;
         for(int j=0; j<count; j++){
            if(items[i]==items[j])
            c++;
         }
         if(c>1){
            if(c>appear){
               mode[0] = items[i];
               appear=c;
            }
         }
      }
      b++;
      for(int i=0; i<count; i++){
         c=0;
         for(int j=0; j<count; j++){
            if(items[i]==items[j])
            c++;
         }
         if(c>1){
            boolean isTrue=false;
            for(int k=0; k<b; k++){
               if(c==appear&&items[i]!=mode[k])
               isTrue=true;
               else
               isTrue=false;
            }
            if(isTrue)
            mode[b++]=items[i];
         }
      }
      System.out.print("Mode: ");
      for(int i=0; i<b; i++){
         System.out.print(mode[i]+" ");
      }
      System.out.println();
   }
   public static void main(String args[]){
      Statistician list = new Statistician();
      
      list.add(4);
      list.add(4);
      list.add(3);
      list.add(2);
      list.add(4);
      list.add(3);
      list.add(2);
      list.add(2);
      list.add(1);
      System.out.println("list: "+list);
      System.out.println("Sum: "+list.sum()+"\nLargest: "+list.largest()+"\nSmallest: "+list.smallest()+"\nMean: "+list.mean()+"\nMedian: "+list.median());
      list.mode();
      
   }
}