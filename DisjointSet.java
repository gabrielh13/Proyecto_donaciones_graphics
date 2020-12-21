
package practica;

import java.util.*; 
 
class DisjointSet { 
    int parent[]; 
    DisjointSet(int n) { 
        parent = new int[n + 1]; 
        for (int i = 0; i <= n; i++) 
            parent[i] = i; 
	} 
    int find(int s){ 
        if (s == parent[s]) 
            return s; 
        return parent[s] = find(parent[s]); 
    } 
    void merge(int u, int v) { 
        parent[v] = u; 
	} 
    } 

class Job implements Comparator<Job> { 
    
	char id; 
	int deadline, profit; 
        
	public Job() { } 
	public Job(char id,int deadline,int profit) 
	{ 
		this.id = id; 
		this.deadline = deadline; 
		this.profit = profit; 
	} 
 
	public static int findMaxDeadline(ArrayList<Job> arr) 
	{ 
		int ans = Integer.MIN_VALUE; 
		for (Job temp : arr) 
			ans = Math.max(temp.deadline, ans); 
		return ans; 
	} 

	public static void printJobScheduling(ArrayList<Job> arr) 
	{ 
            Collections.sort(arr, new Job());  
	    int maxDeadline = findMaxDeadline(arr); 
	    DisjointSet dsu = new DisjointSet(maxDeadline); 
            for (Job temp : arr) { 
                int availableSlot = dsu.find(temp.deadline); 
                if (availableSlot > 0){
                    
                    dsu.merge(dsu.find(availableSlot - 1), availableSlot); 
		    System.out.print(temp.id + " "); 
			} 
		} 
		System.out.println(); 
	} 
        
	public int compare(Job j1, Job j2) { 
            return j1.profit > j2.profit? -1: 1; 
	} 
} 

// Driver code 
class Main 
{ 
	public static void main(String args[]) 
	{ 
		ArrayList<Job> arr=new ArrayList<Job>(); 
		arr.add(new Job('a',2, 100)); 
		arr.add(new Job('b',2, 300)); 
		arr.add(new Job('c',5, 250)); 
		arr.add(new Job('d',5, 90)); 
		arr.add(new Job('e',4, 95)); 
                arr.add(new Job('f',4, 80)); 
		arr.add(new Job('g',6, 120)); 
		arr.add(new Job('h',3, 200)); 
		arr.add(new Job('i',1, 70)); 
      
		Job.printJobScheduling(arr); 
	} 
} 

