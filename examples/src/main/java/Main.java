import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;
import scala.concurrent.Future;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Matriz> matrices = new ArrayList<Matriz>();
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        int [][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };

        ActorSystem matriz = ActorSystem.create("test-system");

        ActorRef obtencion
                = matriz.actorOf(Obtencion.props(mat1Values,mat2Values, matriz),"obtencion");
        matriz.stop(obtencion);
        Future<Terminated> terminateResponse = matriz.terminate();

    }

}
