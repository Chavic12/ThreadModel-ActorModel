import java.util.ArrayList;
import java.util.List;

public class Matriz {
    public Matriz multiplyWithThreads(Matriz mat2) throws InterruptedException{
        List<TaskCalcElement> threads;
        if(values.length == mat2[0].length){
            int[][] output = new int [values.length][mat2.values[0].length];
            threads = new ArrayList<>();
            for(var i = 0; i < output.length; i++  ){
                for (int j = 0; j < output[0].length; j++) {
                    TaskCalcElement thread = new TaskCalcElement(this, mat2, i, j);
                    thread.start();
                    threads.add(thread);
                }
            }
            setWaitThreads(threads);
            for(var t: threads){
                output[t.getRowIndex()][t.getColIndex] = t.getElement();
            }
            return new Matriz(output);

            }else {
            throw new IllegalArgumentException("No se puede multiplicar");
        }
        }

    private void setWaitThreads(List<TaskCalcElement> threads) throws InterruptedException{
        for(var t : threads){
            t.join();
        }

    }

}


