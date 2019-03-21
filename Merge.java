import java.util.Arrays;
public class Merge{
  public static void merge(int[]data,int []dataA,int[] dataB){// must be sorted
           int[]result=new int[dataA.length+dataB.length];
          // result[0]=low;
           //result[result.length-1]=high;
           int resultIndex=0;
           int iB=0;
           int iA=0;
           while(iB<dataB.length && iA<dataA.length){
            // System.out.println(Arrays.toString(result));
             if(dataA[iA]<dataB[iB]){
               result[resultIndex]=dataA[iA];
               resultIndex++;
               iA++;
             }
             else if(dataA[iA]==dataB[iB]){
               result[resultIndex]=dataA[iA];
               result[resultIndex+1]=dataA[iA];
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
          // System.out.println(Arrays.toString(result));
           if(iB<dataB.length){
             for(int i=iB;i<dataB.length;i++){
               result[resultIndex]=dataB[i];
               resultIndex++;
             }
           }
          // System.out.println(Arrays.toString(result));
           if(iA<dataA.length){
             for(int i=iA;i<dataA.length;i++){
               result[resultIndex]=dataA[i];
               resultIndex++;
             }
           }
          // System.out.println(Arrays.toString(result));
           for(int i=0;i<data.length;i++){
             data[i]=result[i];
           }
          // System.out.println(Arrays.toString(result));

  }
  public static void insertion(int[]ary){
    int marker=0;
    for(int i=1;i<ary.length;i++){
      int compare=ary[i];
      int index=i;
      for(int j=i-1;j>=0;j--){
        if (compare<ary[j]){ // switched position here
          int temp=ary[j];
          ary[j]=compare;
          ary[index]=temp;
          index=j;
        }
      }
    }
  }
  public static void Mergesort(int[]data,int[]storageA,int[]storageB){// cuts down the length of array to 1
	    /// System.out.println(Arrays.toString(data));
        int length=data.length;
        while (length>8){
           for(int i=0;i<data.length/2;i++){
             storageA[i]=data[i];
           }
           int index=0;
           for(int i=data.length/2;i<data.length;i++){
             storageB[index]=data[i];
             index++;
           }
           int[]temp1=new int[storageA.length/2];
           int[]temp2=new int[storageA.length-temp1.length];
           int[]temp3=new int[storageB.length/2];
           int[]temp4=new int[storageB.length-temp3.length];
           Mergesort(storageA,temp1,temp2);
           Mergesort(storageB,temp3,temp4);

           merge(data,storageA,storageB);
          // System.out.println(Arrays.toString(data));
           length=8;
        }
        insertion(data);

       // System.out.println(Arrays.toString(storageA));
        //System.out.println(Arrays.toString(storageB));
        //data=merge(storageA,storageB,0,1);
  }
  public static void mergesort(int[]ary) {
	  int[]storageA=new int[ary.length/2];
	  int[]storageB=new int[ary.length-storageA.length];
	  Mergesort(ary,storageA,storageB);
	//  System.out.println(Arrays.toString(storageA));
	//  System.out.println(Arrays.toString(storageB));

  }
  public static void main(String[]args) {
	  int[]ary= {2,3,3,1,4,5,6,10,8,34,3323,322,21,-323,849,344,2,2,222,31,121,3232,9000000,1,0};
    int[]test=new int[10];
    for(int i=0;i<10;i++){
      test[i]=10-i;
    }
	 mergesort(ary);
	 System.out.println(Arrays.toString(ary));
  }
}
