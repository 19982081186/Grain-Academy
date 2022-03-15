package Quene;

public class ArryQueneDemo {
    private int maxSize; //表示数组的最大容量
    private int front;//队列头，指向队列头元素的前一个位置
    private int rear;//队列尾，指向队列尾元素
    private int[]arr;//该数据用于存放数据,模拟队列

    public ArryQueneDemo(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置.
        rear = -1;  //指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //添加数据到队列 rear+1
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;
        //让rear后移
        arr[rear]=n;
    }
    

}
