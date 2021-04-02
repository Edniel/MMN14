/**
 * Write a description of class Ex14 here.
 *
 * @author Eden Lavi
 * @version 314649799
 */
public class Ex14
{
    public static void Main(){
        //Third task
        boolean[][] matA={{false,false,false},{false,true,false},{false,true,false},{false,false,false}};
        boolean[][] matB={{false,true,false,false,true},{true,false,false,true,true},{false,false,true,true,false,},
                {true,false,false,false,false},{true,true,true,false,false}};
        //print(matB);
        //System.out.println(size(matB,2,2));
        //System.out.println(size(matB,0,1));
        //System.out.println(size(matB,1,4));
        //size(matB,1,3);
        size0(matB,4,1);
        size0(matB,4,0);
        size0(matB,4,2);
        size0(matB,3,0);
    }

    /**
     * This method returns the highest drop between two numbers.The low number must appear after the high number.
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
        int[][] measures=new int[2][mat.length];
        for(int x=0;x<mat.length;x++)
            for(int y=0;y<mat[0].length;y++){
                measures[0][x]+=mat[x][y];
                measures[1][y]+=mat[x][y];
            }
        for(int temp=0;temp<mat.length;temp++)
            if(measures[0][temp]==0 && measures[1][temp]==mat.length-1)
                return temp; 
        return -1;
    }

    public static int size0(boolean[][] mat,int x,int y){
        int sum=0;
        if(x<0 || y<0|| x>=mat.length || y>=mat[0].length || mat[x][y]==false)
            return sum;
        sum++;
        //0--> x-1
        if(x>0 && mat[x-1][y]==true){
            sum+=size0(mat,x,y,0);
        }
        //1-->y-1
        if(y>0 && mat[x][y-1]==true){
            sum+=size0(mat,x,y,1);
        }
        //2-->x+1
        if(x<mat.length-1 && mat[x+1][y]==true){
            sum+=size0(mat,x,y,2);
        }
        //3-->y+1
        if(y<mat[0].length-1 && mat[x][y+1]==true){
            sum+=size0(mat,x,y,3);
        }
        //4-->x+1, y+1
        if(y<mat[0].length-1 && x<mat.length-1 && mat[x+1][y+1]==true){
            sum+=size0(mat,x,y,4);
        }
        //5--> x+1,y-1
        if(y>0 && x<mat.length-1 && mat[x+1][y-1]==true){
            sum+=size0(mat,x,y,5);
        }
        //6--> x-1,y-1
        if(y>0 && x>0 && mat[x-1][y-1]==true){
            sum+=size0(mat,x,y,6);
        }
        if(y<mat[0].length-1 && x>0 && mat[x-1][y+1]==true){
            sum+=size0(mat,x,y,7);
        }
        System.out.println("Sum is:"+sum);
        return sum;
    }

    private static int size0(boolean[][] mat,int x,int y,int num){
        int sum=0;
        System.out.println("num is:"+num);
        switch(num){
            //x--> x-1
            case 0:if(x>0 && mat[x-1][y]==true){
                sum++;
                sum+=size0(mat,x-1,y,0);

            }break;
            //y--> y-1
            case 1:if(y>0 && mat[x][y-1]==true){
                sum++;
                sum+=size0(mat,x,y-1,1);

            }break;

            case 2:if(x<mat.length-1 && mat[x+1][y]==true){
                sum++;
                sum+=size0(mat,x+1,y,2);

            }break;

            case 3:if(y<mat[0].length-1 && mat[x][y+1]==true){
                sum++;
                sum+=size0(mat,x,y+1,3);

            }break;

            case 4:if(y<mat[0].length-1 && x<mat.length-1 && mat[x+1][y+1]==true){
                sum++;
                sum+=size0(mat,x+1,y+1,4);

            }break;

            case 5:if(y>0 && x<mat.length-1 && mat[x+1][y-1]==true){
                sum++;
                sum+=size0(mat,x+1,y-1,5);

            }break;

            case 6:if(y>0 && x>0 && mat[x-1][y-1]==true){
                sum++;
                sum+=size0(mat,x-1,y-1,6);

            }break;

            case 7:if(y<mat[0].length-1 && x>0 && mat[x-1][y+1]==true){
                sum++;
                sum+=size0(mat,x-1,y+1,7);

            }break;
        }
        System.out.println(sum);
        return sum;
    }

    /**
     * This method
     * @param
     * @return
     */
    private static void print(int[][] a){
        for(int x=0;x<a.length;x++){
            if(x!=0)System.out.println();
            for(int y=0;y<a[0].length;y++)
                System.out.print(a[x][y]+" ");
        }
        System.out.println();
    }

    private static void print(boolean[][] a){
        for(int x=0;x<a.length;x++){
            if(x!=0)System.out.println();
            for(int y=0;y<a[0].length;y++)
                System.out.print(a[x][y]+" ");
        }
        System.out.println();
    }

    public static int size1(boolean[][] mat,int x,int y){
        if(x<0 || y<0 || x>=mat.length|| y>=mat[0].length|| mat[x][y]==false)
            return 0;
        int temp=1;
        int[][] sinks=new int[2][mat.length*mat[0].length];
        sinks[0][0]=x;
        sinks[1][0]=y;
        temp=size1(mat,x,y,sinks,temp);
        return temp;
    }

    private static int size1(boolean[][] mat,int x,int y,int[][] sinks,int temp){
        if(x<mat.length && y<mat[0].length && mat[x+1][y+1]==true)
            if(checkPoint(sinks,x+1,y+1)){
                sinks[0][temp]=x;
                sinks[1][temp]=y;
                size1(mat,x,y,sinks,++temp);
            }

        return temp;
    }

    private static boolean checkPoint(int[][] sinks,int x,int y){
        for(int t=0;t<sinks[0].length;t++){
            if(sinks[0][t]==x && sinks[1][t]==y)
                return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
   public static boolean isPermutation(int[] a,int[] b){
     return isPermutation(a,b,0,0);  
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
