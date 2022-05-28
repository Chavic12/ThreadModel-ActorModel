package ActorModel;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Obtencion extends AbstractActor {
    int[][] m1;
    int[][] m2;
    ActorSystem fath;

    public static Props props(int[][] m1, int[][] m2, ActorSystem fath) {
        return Props.create(Obtencion.class, () -> new Obtencion(m1, m2, fath));
    }
    public Obtencion(int[][] m1, int[][] m2, ActorSystem fath) {
        this.m1 = m1;
        this.m2 = m2;
        this.fath = fath;
    }

    @Override
    public Receive createReceive() {

        Matriz mat1 = new Matriz(m1);
        Matriz mat2 = new Matriz(m2);
        if (m1.length == m2[0].length) {
            int[][] output = new int[m1.length][m2[0].length];
            for (var i2 = 0; i2 < output.length; i2++) {
                for (var j2 = 0; j2 < output[0].length; j2++) {
                    this.fath.actorOf(CalculoElemento.props(mat1,mat2,i2, j2,output,fath),"calculoElemento"+i2+j2);
                }
            }
        }else{
            System.out.println("No se puede multiplicar");
        }
        return receiveBuilder().build();
    }
}
