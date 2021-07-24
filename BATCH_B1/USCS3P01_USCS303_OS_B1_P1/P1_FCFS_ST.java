import java.util.Scanner;

public class P1_FCFS_ST {
  // defining variables
  int burstTime[];
  int arrivalTime[];
  String[] processId;
  int numberOfProcess;

  // getting user data
  void getProcessData(Scanner input) {
    System.out.print("Enter the number of Process for Scheduling: ");
    int inputNumberOfProcess = input.nextInt();
    numberOfProcess = inputNumberOfProcess;
    burstTime = new int[numberOfProcess];
    arrivalTime = new int[numberOfProcess];
    processId = new String[numberOfProcess];
    String st = "P";

    for(int i=0; i<numberOfProcess; i++) {
      processId[i] = st.concat(Integer.toString(i));
      System.out.print("Enter the burst time for process - " + (i) + " : ");
      burstTime[i] = input.nextInt();
      System.out.print("Enter the arrival time for process - " + (i) + " : ");
      arrivalTime[i] = input.nextInt();
    }
  }

  void sortAccordingArrivalTime(int[] at, int[] bt, String[] pid) {
    boolean swapped;
    int temp;
    String stemp;
    for(int i=0; i<numberOfProcess; i++) {
      swapped = false;
      for(int j=0; j<numberOfProcess-i-1; j++) {
        if(at[j] > at[j+1]) {
          // swapping arrival time
          temp = at[j];
          at[j] = at[j+1];
          at[j+1] = temp;

          // swapping burst time
          temp = bt[j];
          bt[j] = bt[j+1];
          bt[j+1] = temp;

          // swapping process id
          stemp = pid[j];
          pid[j] = pid[j+1];
          pid[j+1] = stemp;

          // enhanced bubble sort
          swapped = true;
        } // if ends
      }   // inner for (j) ends
      if (swapped == false) {
        break;
      }
    }
  }

  void firstComeFirstServeAlgorrithm() {
    int finishTime[] = new int[numberOfProcess];
    int bt[] = burstTime.clone();
    int at[] = arrivalTime.clone();
    String pid[] = processId.clone();
    int waitingTime[] = new int[numberOfProcess];
    int turnAroundTime[] = new int[numberOfProcess];

    sortAccordingArrivalTime(at,bt,pid);

    // calculating waiting & turn-around time for each process
    finishTime[0] = at[0] + bt[0];
    turnAroundTime[0] = finishTime[0] - at[0];
    waitingTime[0] = turnAroundTime[0] - bt[0];
    for (int i=1; i<numberOfProcess; i++) {
      finishTime[i] = bt[i] + finishTime[i-1];
      turnAroundTime[i] = finishTime[i] - at[i];
      waitingTime[i] = turnAroundTime[i] - bt[i];
    }

    float sum=0;
    for(int n:waitingTime) {
      sum+=n;
    }
    float averageWaitingTime = sum/numberOfProcess;

    sum=0;
    for(int n:turnAroundTime) {
      sum += n;
    }
    float averageTurnAroundTime = sum/numberOfProcess;

    // print on console the order of processes scheduled using
    // forstcomefirstserver algorithm
    System.out.println("FCFS Scheduling Algorithm: ");
    System.out.format("%20s%20s%20s%20s%20s%20s\n", "ProcessId", "BurstTime",
                      "ArrivalTime", "FinishTime", "TurnAroundTime",
                      "WaitingTime");

    for(int i=0; i<numberOfProcess; i++) {
      System.out.format("%20s%20s%20s%20s%20s%20s\n", pid[i], bt[i], at[i],
                        finishTime[i], turnAroundTime[i], turnAroundTime[i],
                        waitingTime[i]);
    }

    System.out.format("%80s%20f%20f\n", "Average", averageTurnAroundTime,
                      averageWaitingTime);
  }

  public static void main(String[] ars) {
    Scanner input = new Scanner(System.in);
    P1_FCFS_ST obj = new P1_FCFS_ST();
    obj.getProcessData(input);
    obj.firstComeFirstServeAlgorrithm();
  }
}