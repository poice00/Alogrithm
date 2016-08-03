package D_backTrack;
public class Queen {

	private final int size;//棋盘的大小，也表示皇后的数目
	private int[] location;//皇后在期盼的每行上的列的位置
	private int[] colsOccupied;//皇后在棋盘上占据的列
    private int[] cross1Occupied;//皇后在棋盘上占据的反正对角线
    private int[] cross2Occupied;//皇后在棋盘上占据的反对角线
    private static int count;//解决方案个数
 
    private static final int STATUS_OCCUPIED=1;//占领
    private static final int STATUS_OCCUPY_CANCELED=0;//未占领
 
	 public Queen(int size)//初始化
	 {
	  this.size=size;
	  location=new int[size];
	  colsOccupied=new int[size];
	  cross1Occupied=new int[2*size];
	  cross2Occupied=new int[2*size];
	  
	 }
 
	 public void printLocation(){
		 
		System.out.println("以下是皇后在棋盘上的第"+count+"种摆放位置");
		int [][]a = new int[size][size];
		for(int i=0;i<size;i++)
			  for (int j = 0; j < size; j++) {
				a[i][location[i]] = 8;
			  }
		for (int[] js : a) {
			for (int j : js) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		System.out.println();
	 }
 
	 private boolean isOccupied(int i, int j)//判断位置（i，j）是否被占领
	 {
		 return (colsOccupied[j]==STATUS_OCCUPIED)||(cross1Occupied[i-j-1+size]==STATUS_OCCUPIED)||(cross2Occupied[i+j]==STATUS_OCCUPIED);
	 }
 
	 private void setStatus(int i,int j,int flag)//如果flag为1，表示占领位置（i，j），否则表示取消占领
	 {
		  colsOccupied[j]=flag;//宣布占领或取消占领第j列
		  cross1Occupied[i-j-1+size]=flag;//宣布占领或取消占领正对角线
		  cross2Occupied[i+j]=flag;//宣布占领或取消占领反对角线
	 }
 
	 public void place(int i)//从第i行开始摆放皇后
	 {
		  for(int j=0;j<size;j++)//在第i行分别尝试把皇后放在每一列上
		  {
			   if(!isOccupied(i,j))//判断该位置是否被占领
			   {
				   location[i]=j;//摆放皇后，在第i行把皇后放在第j列
				   setStatus(i,j,STATUS_OCCUPIED);//宣布占领位置（i，j）
				   if(i<size-1)
					   place(i+1);//如果所有皇后没有摆完，递归摆放下一行的皇后
				    else
				    {
				    	count++;//统计解决方案的个数
				    	printLocation();//完成任务，打印所有皇后的位置
				    }
				   setStatus(i,j,STATUS_OCCUPY_CANCELED);//回溯，撤销占领位置（i,j）
			   }
		  }
	 }
 
	 public void start()
	 {
		 place(0);//从第0行开始放置皇后
	 }
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	     new Queen(8).start();
	 }

}
