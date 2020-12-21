
package ada.lab;
import java.util.*;
import java.util.stream.Collectors;
 
class Greedy {
    public int taskID, deadline, profit;

    public Greedy(int taskID, int deadline, int profit) {
        this.taskID = taskID;
        this.deadline = deadline;
        this.profit = profit;
    }
}
class Main {
    public static int scheduleJobs(List<Greedy> jobs, int T){
        int profit = 0;
        
        int[] slot = new int[T];
        Arrays.fill(slot, -1);
       
        for (Greedy job: jobs){
            for (int j = job.deadline - 1; j >= 0; j--){
                if (j < T && slot[j] == -1)
                {
                    slot[j] = job.taskID;
                    profit += job.profit;
                    break;
                }
            }
        }
 
        System.out.println("The Scheduled jobs are: " +
                Arrays.stream(slot).filter(val -> val != -1).boxed()
                        .collect(Collectors.toList()));

        return profit;
    }
 
    public static void main(String[] args) {
        List<Greedy> jobs = Arrays.asList(//GREED
                new Greedy(1, 2, 100), //Lecturas
                new Greedy(2, 1, 300), //Estudiar
                new Greedy(3, 5, 250), //Tareas de programacion
                new Greedy(4, 5, 90), //dormir
                new Greedy(5, 4, 95), //meditar
                new Greedy(6, 4, 80), //entretenimiento
                new Greedy(7, 6, 120), //elaborar articulo
                new Greedy(8, 3, 200), //programar
                new Greedy(9, 1, 70) //redes sociales
        );
        final int T = 15;
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);
        scheduleJobs(jobs,T);
        
        System.out.println("Total Profit is: " + "Estudiar(examen) - Lectura - programar - meditar - tareas - Elaborar articulo ");
        System.out.println("Ganancia: 1065");
    }
}




