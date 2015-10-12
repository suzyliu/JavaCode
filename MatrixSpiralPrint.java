

class Pramp {
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }
   
   public static void matrixSpiralPrint(int[][] m){
      int top=-1;
      int left=-1;
      int right=m[0].length;
      int bot=m.length;
      int dir=0;   //
      int counter=0,i=0,j=0;
      while(counter<m[0].length*m.length){
         System.out.println(m[i][j]);
         counter++;
         switch(dir){
            case 0:
               if(j+1 >= right){
                  dir=1;
                  top++;//top=0
                  i++;
               }else{
                  j++;
               }
               break;
            case 1:
               if(i+1 >= bot){
                  dir=2;
                  right--;//right=4
                  j--;
               }else{
                  i++;
               }
               break;
            case 2:
            if(j-1 <= left){
                  dir=3;
                  bot--;//bot=4
                  i--;
               }else{
                  j--;
               }
               break;
            case 3:
            if(i-1 <= top){
                  dir=0;
                  left++;//left=0
                  j++;
               }else{
                  i--;
               }
               break;   
         }
      }
      
   }
   
}