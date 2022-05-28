package ActorModel;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;

import java.io.IOException;


public class Main {
    public static ActorRef obtencion;
    public static ActorRef calculoElemento;
    public static ActorRef resultados;
    public static void main(String[] args) throws IOException, InterruptedException {

        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        int [][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };

        ActorSystem matriz = ActorSystem.create("matriz");
        ActorRef obtencion
                = matriz.actorOf(Obtencion.props(mat1Values,mat2Values, matriz),"obtencion");

    }

}
