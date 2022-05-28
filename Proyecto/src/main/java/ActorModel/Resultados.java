package ActorModel;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Resultados extends AbstractActor {
    private int total;
    private int index;
    private int column;
    private int [][]output;
    private ActorSystem fath;

    public Resultados(int total, int index, int column, int[][] output, ActorSystem fath) {
        this.total = total;
        this.index = index;
        this.column = column;
        this.output = output;
        this.fath = fath;
    }

    public Resultados(){

    }
    public static Props props(int total, int index, int column, int[][] output,ActorSystem fath) {

        return Props.create(Resultados.class, () -> new Resultados(total, index, column, output, fath));
    }

    @Override
    public Receive createReceive() {
        output[index][column]=total;
        if(output[2][2]>0 && output[0][0]>0 && output[0][1]>0 && output[0][2]>0 && output[1][0]>0 &&
                output[1][1]>0 && output[1][2]>0) {
            fath.terminate();
            Matriz out = new Matriz(output);
            System.out.println(out);
        }



        return receiveBuilder().build();
    }

}
