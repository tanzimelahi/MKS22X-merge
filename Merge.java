public class Merge{
  public static int[] merge(int []dataA,int[] dataB,int low,int high){// must be sorted
           int[]result=new int[dataA.length+dataB.length];
           result[0]=low;
           result[result.length-1]=high;
           int resultIndex=0;
           int iB=0;
           int iA=0;
          // int minLimit=Math.min(dataA.length,dataB.length);
           while(iB<dataB.length && iA<dataA.length){
             if(dataA[iA]<dataB[iB]){
               result[resultIndex]=dataA[iA];
               resultIndex++;
               iA++;
             }
             else if(dataA[iA]==dataB[iB]){
               result[resultIndex]=dataA[iA];
               resultIndex+=2;
               iA++;
               iB++;
             }
             else{
               result[resultIndex]=dataB[iB];
               resultIndex++;
               iB++;
             }
           }
           if(iB<dataB.length){
             for(int i=iB;i<dataB.length;i++){
               result[resultIndex]=dataB[i];
               resultIndex++;
             }
           }
           if(iA<dataA.length){
             for(int i=iA;i<dataA.length;i++){
               result[resultIndex]=dataA[i];
               resultIndex++;
             }
           }
           return result;
  }
  public static void Mergesort(int[]data,int[]storageA,int[]storageB){// cuts down the length of array to 1
        int length=data.length;
        while (length>1){
           for(int i=0;i<data.length/2;i++){
             storageA[i]=data[i];
           }
           int index=0;
           for(int i=data.length/2;i<data.length;i++){
             storageA[index]=data[i];
             index++;
           }
           int[]temp1=new int[storageA.length/2];
           int[]temp2=new int[storageA.length-temp1.length];
           int[]temp3=new int[storageB.length/2];
           int[]temp4=new int[storageB.length-temp3.length];
           Mergesort(storageA,temp1,temp2);
           Mergesort(storageB,temp3,temp4);
           int low,high;
           if (storageA[0]<=storageB[0]){
             low=storageA[0];
           }
           else{
             low=storageB[0];
           }
           if(storageB[storageB.length-1]>=storageB[storageB.length-1]){
             high=storageB[storageB.length-1];
           }
           else{
             high=storageA[storageB.length-1];
           }
           data=merge(storageA,storageB,low,high);
        }
  }
}
