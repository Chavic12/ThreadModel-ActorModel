public class SumRow extends Thread{
    private int[]row;
    private int sum;

    public SumRow( int [] row){
        this.row = row;
        sum = 0;
    }

    @Override
    public void run() {
        for(var value : row){
            sum+= value;
        }
    }
}
