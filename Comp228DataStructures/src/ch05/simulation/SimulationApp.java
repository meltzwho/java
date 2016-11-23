//---------------------------------------------------------------------
// SimulationApp.java       by Dale/Joyce/Weems               Chapter 5
//
// Simulates customers waiting in queues. Customers always enter
// the shortest queue.
//
// Input consists of customer information:
//    Minimum and maximum customer inter-arrival time.
//    Minimum and maximum customer service time.
// Followed by a sequence of simulation instance information:
//    Number of queues and customers.
//
// Output includes, for each simulation instance:
//    The average waiting time for a customer.
//----------------------------------------------------------------------
package ch05.simulation;

import java.util.Scanner;

public class SimulationApp 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    int minIAT;    // minimum inter-arrival time
    int maxIAT;    // maximum inter-arrival time
    int minST;     // minimum service time
    int maxST;     // maximum service time
    int numQueues; // number of queues
    int numCust;   // number of customers

    String skip;           // skip end of line after reading an integer
    String more = null;    // used to stop or continue processing

    // Get customer information
    System.out.print("Enter minimum inter-arrival time: ");
    minIAT = conIn.nextInt();
    System.out.print("Enter maximum inter-arrival time: ");
    maxIAT = conIn.nextInt();
    System.out.print("Enter minimum service time: ");
    minST = conIn.nextInt();
    System.out.print("Enter maximum service time: ");
    maxST = conIn.nextInt();
    skip = conIn.nextLine();

    // create object to perform simulation
    Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);

    do
    {
      // Get next simulation instance to be processed.
      //**NEW CODE**
      System.out.print("Assignment method (type shortestQueue -or- finishTime): ");
      String assignmentChoice=conIn.nextLine();
      if(assignmentChoice.equalsIgnoreCase("shortestQueue")){
    	  sim.assignment=true;
      }
      else if(assignmentChoice.equalsIgnoreCase("finishTime")){
    	  sim.assignment=false;
    	  System.out.print("(DEBUG) Check if queue with shortest finish time is selected (type y/n): ");
    	  if("y".equals(conIn.nextLine())) sim.debug=true;
      }
      else{
    	  System.out.println("Invalid choice");
    	  more="y";
    	  continue;
      }
      System.out.print("Enter number of queues: ");
      numQueues = conIn.nextInt();     
      System.out.print("Enter number of customers: ");
      numCust = conIn.nextInt();    
      skip = conIn.nextLine();   // skip end of line
      
      // run simulation and output average waiting time
      sim.simulate(numQueues, numCust);
      System.out.println("Average waiting time is " + sim.getAvgWaitTime());
      //**NEW CODE**
      //output longestSize
      System.out.println("Longest size queue: "+sim.longestSize);
      
      // Determine if there is another simulation instance to process
      System.out.println();
      System.out.print("Evaluate another simulation instance? (type y/n): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}