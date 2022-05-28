package ActorModel;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class CalculoElemento extends AbstractActor {
    Matriz m1;
    Matriz m2;
    private int rowIndex;
    private int colIndex;
    ActorSystem resultado;
    int[][] output;
    public CalculoElemento(Matriz m1, Matriz m2, int rowIndex, int colIndex, int[][] output, ActorSystem resultado) {
        this.m1 = m1;
        this.m2 = m2;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.resultado = resultado;
        this.output = output;
    }

    public CalculoElemento(){

    }
    public static Props props(Matriz m1, Matriz m2, int rowIndex, int colIndex, int[][] output, ActorSystem resultado) {
        return Props.create(CalculoElemento.class, () -> new CalculoElemento(m1,m2,rowIndex,colIndex,output, resultado));
    }

    private int element;

    @Override
    public Receive createReceive() {

        element = calcValue(m1.getRow(rowIndex), m2.getColumn(colIndex));
        this.resultado.actorOf(Resultados.props(element,rowIndex,colIndex,output, resultado),"resultados"+element);

        return receiveBuilder().build();
    }

    private int calcValue(int[] row, int[] col) {
        int aux = 0;
        for (var i = 0; i < row.length; i++) {
            aux += row[i] * col[i];
        }
        return aux;
    }


}
