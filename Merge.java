public class Merge{
  public static void Merge(int []dataA,int dataB,int low,int high){

  }
  public static void Mergesort(int[]data,int[]storageA,int[]storageB){// cuts down the length of array to 1
        while (data.length>1){
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
        }
  }
}
