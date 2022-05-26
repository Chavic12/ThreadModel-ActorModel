import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Resultados extends AbstractActor {
    int total;
    int index;
    int column;
    int [][]output = {{1,1}};

    public Resultados(int total, int index, int column, int[][] output) {
        this.total = total;
        this.index = index;
        this.column = column;
        this.output = output;
    }

    public Resultados(){

    }
    public static Props props(int total, int index, int column, int[][] output) {
        return Props.create(Resultados.class, () -> new Resultados(total, index, column, output));
    }
    @Override
    public Receive createReceive() {


        output[index][column]=total;

        String outp = "";
        for (var fila : output) {
            outp += "{";
            for (var value : fila) {
                outp += value + "\t";
            }
            outp += "}\n";
        }
        System.out.println("{\n" + outp + "}");


        return receiveBuilder().build();
    }
}
