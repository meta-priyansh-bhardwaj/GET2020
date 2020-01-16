import java.util.Scanner;

class schedular
{
	/**
	 * Function Completion time calculate
	 * @param Array Completion Time Array 
	 * @param size Size of input
	 * @return completionTimeArray
	 */
	public int[] completion_time(int Array[][], int size)
	{		
		int completeTime = 0;
		int[] completionTimeArray = new int[size];
		completionTimeArray[0] = Array[0][1] + Array[0][0];
		completeTime = completionTimeArray[0];
		for (int i = 1 ; i < size ; i++){
			if (Array[i-1][1] > Array[i][0]){
				completeTime =  completeTime + Array[i][1]; 
			}
			else{
				completeTime = Array[i][0] + Array[i][1];
			}
			completionTimeArray[i] = completeTime;
		}
		return completionTimeArray;
	}
	/**
	 * WaitingTime Function 
 	 * @param Array  waiting Time Array 
	 * @param Size size of input
	 * @return waiting time array
	 */
	public int[] waitingTime(int Array[][], int Size){

		int[] waitingArray = new int[Size];
		waitingArray = turnAroundTime(Array,Size);
		for (int i = 0 ; i < Size ; i++){
			waitingArray[i] = waitingArray[i] - Array[i][1];
		}
		return waitingArray;
	}
	/**
	 * turnAround time function
	 * @param Array turnAround time Array
	 * @param Size size of input
	 * @return turnAround time array
	 */
	
	public int[] turnAroundTime(int Array[][], int Size){
		
		int[] turnAroundArray = new int[Size];
		turnAroundArray = completion_time(Array,Size);
		for (int i = 0 ; i < Size ; i++){
			turnAroundArray[i] = turnAroundArray[i] - Array[i][0];
		}
		return turnAroundArray;
	}
	
	public static void main(String args[]) throws Exception
	{
		int no_of_input;
		
		Scanner input=new Scanner(System.in);
		System.out.println("enter number of process");
		
		try{
			int temp;
			scheduler s=new scheduler();
			no_of_input=input.nextInt();
				if(no_of_input>0)
				{
					int scheduler_matrix[][]=new int[no_of_input][2];
					for(int i=0;i<no_of_input;i++)
					{
						System.out.println("Enter the arrival time and burst time in seconds for procees " + (i + 1));
						for(int j=0;j<2;j++)
						{
							scheduler_matrix[i][j]=input.nextInt();
						}
					}
					System.out.println("Enter 1 to calculate completion time for each process.");
					System.out.println("Enter 2 to calculate waiting time for each process.");
					System.out.println("Enter 3 to calculate turnaround time for each process.");
					System.out.println("Enter 4 to calculate avaerage waiting time.");
					System.out.println("Enter 5 to calculate maximum waiting time.");
					System.out.println("Enter 6 for exit");
					int t;
					t=input.nextInt();
					while(t!=0)
					    {
							if(t==1)
							{
								int result[]=new int[no_of_input];
								result=s.completion_time(scheduler_matrix,no_of_input);
									for (int i = 0 ; i < no_of_input ; i++)
										System.out.println("Completion time for process " + (i + 1) + "is " + result[i]);
							}
							if(t==2)
							{
								int result[]=new int[no_of_input];
								result=s.waitingTime(scheduler_matrix,no_of_input);
									for (int i = 0 ; i < no_of_input ; i++)
										System.out.println("Waiting time for process " + (i + 1) + "is " + result[i]);
							}
							if(t==3)
							{
								int result[]=new int[no_of_input];
								result=s.turnAroundTime(scheduler_matrix,no_of_input);
									for (int i = 0 ; i < no_of_input ; i++)
										System.out.println("Turnaround time for process " + (i + 1) + "is " + result[i]);
							}
							if(t==4)
							{
								int result[]=new int[no_of_input];
								result=s.waitingTime(scheduler_matrix,no_of_input);
									for (int i = 0 ; i < no_of_input ; i++)
										System.out.println("Waiting time for process " + (i + 1) + "is " + result[i]);
							float sum = 0;
							for (int i = 0 ; i < no_of_input; i++){
								sum = sum + result[i];
								System.out.println("Sum=" + sum);
							}
							float averageWaitingTime = sum / no_of_input;
							System.out.println("The Average Waiting Time is " + averageWaitingTime);
						}
							
						else if (t == 5){
							int[] result = new int[no_of_input]; 
							result = s.waitingTime(scheduler_matrix,no_of_input);
							int maximumWaitingTime = result[0];
							for (int i = 0 ; i < no_of_input ; i++){
								if(result[i] > maximumWaitingTime)
									maximumWaitingTime = result[i];
								}
							System.out.println("The Maximum Waiting Time is " + maximumWaitingTime);
						}
						else if(t == 6)
							{
								t=0;
								break;
							}
							System.out.println("enter the choice");
							t=input.nextInt();
					    }
			
				}	}
			catch(Exception e){
				System.out.println("Invalid input");
			}
			
	}
}