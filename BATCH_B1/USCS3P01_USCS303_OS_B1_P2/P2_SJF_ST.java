import java.util.Scanner;
public class P2_SJF_ST
{
int burstTime[];
int arrivalTime[]={0};
String[] processId;
int numberOfProcess;
void getProcessData(Scanner input){
System.out.println("enter the number of process for Scheduling:");
int inputNumberOfProcess=input.nextInt();
numberOfProcess=inputNumberOfProcess;
burstTime=new int[numberOfProcess];
arrivalTime=new int[numberOfProcess];
processId=new String[numberOfProcess];
String st="p";
for(int i=0;i < numberOfProcess;i++){
processId[i]=st.concat(Integer.toString(i));
System.out.print("enter the burst time for process-"+(i)+":");
burstTime[i]=input.nextInt();
}
}
void sortAccordingBurstTime(int[] at,int[] bt,String[] pid){
boolean swapped;
int temp;
String stemp;
for (int i=0;i<numberOfProcess;i++){
swapped=false;
for (int j = 0;j<numberOfProcess-i-1;j++){
if(bt[j]>bt[j+1]){
temp=bt[j];
bt[j]=bt[j+1];
bt[j+1]=temp;
temp=at[j];
at[j]=at[j+1];
at[j+1]=temp;
stemp=pid[j];
pid[j]=pid[j+1];
pid[j+1]=stemp;
swapped=true;
}
}
if(swapped==false){
break;
}
}
}
void shortestJobFirstNPAlgorithm(){
int finishTime[]=new int[numberOfProcess];
int bt[]=burstTime.clone();
int at[]=arrivalTime.clone();
String pid[]=processId.clone();
int waitingTime[]=new int[numberOfProcess];
int turnAroundTime[]=new int[numberOfProcess];
sortAccordingBurstTime(at,bt,pid);
finishTime[0]=at[0]+bt[0];
turnAroundTime[0]=finishTime[0]-at[0];
waitingTime[0]=turnAroundTime[0]-bt[0];
for(int i=1;i<numberOfProcess;i++){
finishTime[i]=bt[i]+finishTime[i-1];
turnAroundTime[i]=finishTime[i]-at[i];
waitingTime[i]=turnAroundTime[i]-bt[i];
}
float sum=0;
for(int n:waitingTime){
sum+=n;
}
float averageWaitingTime=sum/numberOfProcess;
sum=0;
for(int n:turnAroundTime){
sum+=n;
}
float averageTurnAroundTime=sum/numberOfProcess;
System.out.println("SJF (with no preemption) Scheduling Algorithm :");
System.out.format("%20s%20s%20s%20s%20s%20s\n","ProcessId","BurstTime"
,"ArrivalTime","FinishTime","TurnAroundTime","WatingTime");
for(int i=0;i<numberOfProcess;i++){
System.out.format("%20s%20d%20d%20d%20d%20d\n",pid[i],bt[i],at[i]
,finishTime[i],turnAroundTime[i],waitingTime[i]);
}
System.out.format("%80s%20f%20f\n", "Average",averageTurnAroundTime,averageWaitingTime);
}
public static void main(String[] args){
Scanner input=new Scanner(System.in);
P2_SJF_ST obj=new P2_SJF_ST();
obj.getProcessData(input);
obj.shortestJobFirstNPAlgorithm();
}
}