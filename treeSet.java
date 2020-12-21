
package ada.lab;
import java.io.*; 
import java.util.*; 

public class treeSet { 
    public static class Job { 
        char id; 
        int deadline; 
        int profit; 
        Job(char id, int deadline, int profit) { 
	    this.id = id; 
	    this.deadline = deadline; 
	    this.profit = profit; 
	} 
    } 
    public static class Sorted implements Comparator { 
        public int compare(Object o1, Object o2) { 
            Job j1 = (Job)o1;
            Job j2 = (Job)o2; 
            if (j1.profit != j2.profit) 
                return j2.profit - j1.profit; 
            else
                return j2.deadline - j1.deadline;
        } 
    }
    public static void printJobScheduling(Job jobs[], int n){ 
        Sorted sorter = new Sorted(); 
	Arrays.sort(jobs, sorter); 
        
        TreeSet<Integer> ts = new TreeSet<>(); 
        
        for (int i = 0; i < n; i++) 
            ts.add(i); 
        for (int i = 0; i < n; i++) { 
            Integer x = ts.floor(jobs[i].deadline - 1); 
            if (x != null) { 
                System.out.print(jobs[i].id + " "); 
                ts.remove(x); 
            } 
        } 
    } 
	
	public static void main(String[] args) 
	{ 
		int n = 9; 
		Job[] jobs = new Job[n]; 
                //TREESET
		jobs[0] = new Job('a', 2, 100); 
		jobs[1] = new Job('b', 2, 300); 
		jobs[2] = new Job('c', 5, 250); 
		jobs[3] = new Job('d', 5, 90); 
		jobs[4] = new Job('e', 4, 95); 
                jobs[5] = new Job('f', 4, 80); 
		jobs[6] = new Job('g', 6, 120); 
		jobs[7] = new Job('h', 3, 200); 
		jobs[8] = new Job('i', 1, 70); 

		printJobScheduling(jobs, n); 
	} 
} 

