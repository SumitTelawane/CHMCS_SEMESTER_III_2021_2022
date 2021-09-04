import java.util.Scanner;

public class P6_BankersAlgo_ST {
	private int need[][], allocate[][], max[][], avail[][], np, nr;

	private void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of Process: ");
		np = sc.nextInt();	// no of processes
		System.out.print("Enter no. of resources: ");
		nr = sc.nextInt();	// no of resources
		
		// initializing arrays
		need = new int[np][nr];
		max = new int[np][nr];
		allocate = new int[np][nr];
		avail = new int[1][nr];

		for (int i=0; i<np; i++) {
			System.out.print("Enter allocation matrix for Process P " + i + ": ");
			for (int j=0; j<nr;j++)
				allocate[i][j] = sc.nextInt();	// allocation matrix
		}

		for (int i=0; i<np; i++) {
			System.out.print("Enter maximum matrix for process P " + i + ": ");
			for (int j=0; j<nr; j++)
				max[i][j] = sc.nextInt();		// max matrix
		}

		System.out.print("Enter available matrix for processs P0: ");
		for (int j=0; j<nr;j++)
			avail[0][j] = sc.nextInt();			// available matrix

		sc.close();
	}	// input() ends

	private int[][] calc_need(){
		for (int i=0; i<np; i++) {
			for(int j=0; j<nr; j++)		// calculating need matrix
				need[i][j] = max[i][j] - allocate[i][j];
		}
		return need;
	}	// calc_need() ends

	private boolean check(int i) {
		// checking if all resources for ith process can be allocated
		for (int j=0; j<nr; j++) {
			if(avail[0][j]<need[i][j])
				return false;
		}
		return true;
	}	// check() ends

	public void isSafe() {
		input();
		calc_need();
		boolean done[] = new boolean[np];
		int j=0;

		// printing Need Matrix
		System.out.println("================ Need Matrix ================");
		for (int a=0; a<np; a++) {
			for (int b=0; b<nr; b++) {
				System.out.print(need[a][b] + "\t");
			}
			System.out.println();
		}

		System.out.println("Allocated process: ");
		// until all process allocated
		while(j<np) {
			boolean allocated = false;

			for (int i=0; i<np; i++) {
				// trying to allocate
				if (!done[i] && check(i)) {
					for(int k=0; k<nr; k++) 
						avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
					System.out.print("P"+i+">");
					allocated=done[i]=true;
					j++;
				}	// if block

			}	// for ends
			if(!allocated)
				break;	// if no allocation
		}	// while ends
		if(j==np)	// if all processes are allocated
			System.out.println("\nSafely allocated");
		else
			System.out.println("All/Remaining process can\'t be allocated Safely");
	}	// isSafe() ends
	public static void main(String[] args) {
		new P6_BankersAlgo_ST().isSafe();
	}
}
