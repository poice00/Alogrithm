package hadoop_6;
public class BitSet {  
  
    private int[] mBits;  
    private int mSize;  
      
    /** 
     * 初始化指定个bit 
     * @param size 初始化的bit数目 
     */  
    public BitSet(int size) {  
        mSize = size;  
        initBits();  
    }  
      
    /** 
     * 将指定bit位置设为1 
     * @param pos  
     */  
    public void set(int pos) {  
        //得到此pos在数组中的索引  
        int index = (int)Math.floor(pos/32f);  
        //把当前整数的第n位设置为1  
        mBits[index] = mBits[index] | (1<<(pos%32));  
    }  
      
    /** 
     * 获取指定位是否存在 
     * @param pos 
     * @return 
     */  
    public boolean get(int pos) {  
        int index = (int)Math.floor(pos/32f);  
        return mBits[index] == (mBits[index] | 1<<(pos%32));  
    }  
      
    /** 
     * 指定bit位置设为0 
     * @param pos 
     */  
    public void reset(int pos) {  
        int index = (int)Math.floor(pos/32f);  
        //把当前整数的第n位设置为0  
        mBits[index] = mBits[index] & ~(1<<(pos%32));  
    }  
      
    /** 
     * 初始化整型数组 
     */  
    private void initBits() {  
        //Java中整型为32位，所以数组长度为位长度/32。  
        int count = (int) Math.ceil(mSize/32f);  
        mBits = new int[count];  
        clear();  
    }  
      
    /** 
     * 清空，全部置零 
     */  
    private void clear() {  
        int len = mBits.length;  
        for(int index=0; index<len; index++) {  
            mBits[index] = 0;  
        }  
    }  
}  