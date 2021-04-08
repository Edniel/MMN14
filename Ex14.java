/**
 * Write a description of class Ex14 here.
 *
 * @author Eden Lavi
 * @version 314649799
 */
public class Ex14
{
   /**
     * This method returns the highest drop between two numbers.The high number must appear first.
     * @param a an int array for sorting the highest drop
     * @return an int represeting the highest "drop" (natural numbers differance).
     * with a complexity of O(n).
     */
    public static int maximalDrop(int[] a){
        int highestNum=a[0],lowestNum=a[0],drop=0;
        for(int t=1;t<a.length;t++){
            if(a[t]>highestNum){
                highestNum=a[t];
                lowestNum=highestNum;
            }            
            if(a[t]<lowestNum)
                lowestNum=a[t];
            if(highestNum-lowestNum>drop)
                drop=highestNum-lowestNum;
        }
        return drop;
    }

    /**
     * This method
     * @param
     * @return
     */
    public static int isSink(int[][] mat){
        int[][] measures=measure(mat);
        return checkMeasures(measures,0);
    }

    private static int[][] measure(int[][] mat){
        int[][] measures=new int[2][mat.length];
        return measure(mat,0,0,measures);
    }

    private static int[][] measure(int[][] mat,int x,int y,int[][]measures){
        if(y==mat.length)
            return measures;
        if(x==mat.length)
            return measure(mat,0,y+1,measures);
        measures[0][x]+=mat[x][y];
        measures[1][y]+=mat[x][y];
        return measure(mat,x+1,y,measures);
    }

    private static int checkMeasures(int[][]measures,int temp){
        if(temp==measures[0].length)
            return -1;
        if(measures[0][temp]==0 && measures[1][temp]==measures[0].length-1)
            return temp;
        return checkMeasures(measures,temp+1);
    }
public static int size(boolean[][] mat,int x,int y){
        if(x<0 || x>=mat.length || y<0 || y>=mat[0].length || mat[x][y]!=true) 
            return 0;
        int sum=1;
        mat[x][y]=false;
        //x++,y++
        if(x<mat.length-1 && y<mat[0].length-1 && mat[x+1][y+1]==true)
            sum+=size(mat,x+1,y+1);

        //x++
        if(x<mat.length-1 && mat[x+1][y]==true)
            sum+=size(mat,x+1,y);

        //y++
        if(y<mat[0].length-1 && mat[x][y+1]==true)
            sum+=size(mat,x+1,y);

        //x--,y++
        if(x>0 && y<mat[0].length-1 && mat[x-1][y+1]==true)
            sum+=size(mat,x-1,y+1);

        //x--,y--
        if(x>0 && y>0 && mat[x-1][y-1]==true)
            sum+=size(mat,x-1,y-1);

        //x--
        if(x>0 && mat[x-1][y]==true)
            sum+=size(mat,x-1,y);

        //y--
        if(y>0 && mat[x][y-1]==true)
            sum+=size(mat,x,y-1);

        //x++,y--
        if(x<mat.length-1 && y>0 && mat[x+1][y-1]==true)
            sum+=size(mat,x+1,y-1);

        return sum;
    }
    /**
     * This method
     * @param
     * @return
     */ 
   public static boolean isPermutation(int[] a,int[] b){
        if(a.length != b.length || calculateSum(a)!=calculateSum(b)) 
            return false;
        if(isPermutation(a,b,0,0))
            return true;
        return false;
    }
    private static int calculateSum(int[] arr){
        return calculateSum(arr,0,0);
    }

    private static int calculateSum(int[] arr,int temp,int sum){
        if(temp==arr.length)
            return sum;
        return calculateSum(arr,temp+1,sum+arr[temp]);
    }
    private static boolean isPermutation(int[] a,int[] b,int ind,int temp){
        if(ind==a.length)
            return true;
        if(temp==b.length)
            return false;
        if(a[ind]==b[temp])
            return isPermutation(a,b,ind+1,0);
        return isPermutation(a,b,ind,temp+1);
    }
}
