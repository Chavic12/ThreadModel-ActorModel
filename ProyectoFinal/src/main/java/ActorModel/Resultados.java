package ActorModel;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Resultados extends AbstractActor {
    int total;
    int index;
    int column;
    int [][]output;
    ActorSystem fath;

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
        imp();
        fath.terminate();

        return receiveBuilder().build();
    }

    public void imp() {
        String outp = "";
        for (var fila : output) {
            outp += "{";
            for (var value : fila) {
                outp += value + "\t";
            }
            outp += "}\n";
        }
        System.out.println("{\n" + outp + "}");
    }
}
