public class TaskCalcElement extends Thread{

    public int calcValue(int row[], int col[]){
        int element = 0;
        for (var i = 0; i < row.length; i++) {
            element += row[i] * col[i];
        }
        return element;
    }
}
