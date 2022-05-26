import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.ArrayList;
import java.util.List;

public class Obtencion extends AbstractActor {
    int[][] m1;
    int[][] m2;
    ActorSystem enviar;
    public int[][] values;
    public static Props props(int[][] m1, int[][] m2, ActorSystem enviar) {
        return Props.create(Obtencion.class, () -> new Obtencion(m1,m2,enviar));
    }
    public Obtencion(int[][] m1, int[][] m2, ActorSystem enviar) {
        this.m1 = m1;
        this.m2 = m2;
        this.enviar = enviar;

    }

    @Override
    public Receive createReceive() {

        Matriz mat1 = new Matriz(m1);
        Matriz mat2 = new Matriz(m2);
        if (m1.length == m2[0].length) {
            int[][] output = new int[m1.length][m2[0].length];
            for (var i2 = 0; i2 < output.length; i2++) {
                for (var j2 = 0; j2 < output[0].length; j2++) {
                    this.enviar.actorOf(CalculoElemento.props(mat1,mat2,i2, j2,output,enviar),"calculoElemento"+i2+j2);

                }
            }
        }
        return receiveBuilder().build();
    }

//


}
