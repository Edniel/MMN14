public class Tester{
  public static void Main(){
    //First task
        int[] a1={5,21,3,22,12,7,27,6,4};
        System.out.println(maximalDrop(a1));//23
        int[] a2={5,21,3,22,12,7,26,14};
        System.out.println(maximalDrop(a2));//18
        int[] a3={5,15,3,22,12,7,27,14};
        System.out.println(maximalDrop(a3));//15
    
    //Second task
        int[][] exA={{0,1,0,1,1,0},{1,0,1,1,0,0},{0,0,0,1,0,1},{0,0,0,0,0,0},{1,0,1,1,0,0},{0,1,0,1,1,1}};
        print(exA);
        System.out.println("************");
        int[][] exB={{0,1,0,0,0,1},{1,0,0,1,1,1},{0,0,0,0,0,0},{1,1,1,1,1,1},{0,1,0,1,0,1},{1,0,0,0,1,0}};
        print(exB);
        System.out.println(isSink(exA));
        System.out.println(isSink(exB));
         
  
  
  
  
  }



}
