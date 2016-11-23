//---------------------------------------------------------------------
// Simulation.java           by Dale/Joyce/Weems              Chapter 5
//
// Models a sequence of customers being serviced
// by a number of queues.
//---------------------------------------------------------------------
package ch05.simulation;

import support.*;       // Customer, CustomerGenerator
import ch05.queues.*;

public class Simulation 
{
  //**NEW CODE**
  public int longest=-1,longestSize=-1;
  public int shortestFinishTime=Integer.MAX_VALUE,shortestFinishTimeQ=-1;
  public boolean assignment,debug;
  //	
  
  final int MAXTIME = Integer.MAX_VALUE; 
                               
  CustomerGenerator custGen;   // a customer generator
  float avgWaitTime = 0.0f;    // average wait time for most recent simulation

  public Simulation(int minIAT, int maxIAT, int minST, int maxST)
  {
    custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
  }
  
  public float getAvgWaitTime()
  {
    return avgWaitTime;
  }

  public void simulate(int numQueues, int numCustomers)
  // Preconditions: numQueues > 0
  //                numCustomers > 0
  //                No time generated during simulation is > MAXTIME
  //
  // Simulates numCustomers customers entering and leaving the
  // a queuing system with numQueues queues
  {
    // the queues
    GlassQueue<Customer>[] queues = new GlassQueue[numQueues]; 

    Customer nextCust;      // next customer from generator
    Customer cust;          // holds customer for temporary use
    
    int totWaitTime = 0;    // total wait time
    int custInCount = 0;    // count of customers started so far
    int custOutCount = 0;   // count of customers finished so far
 
    int nextArrTime;        // next arrival time
    int nextDepTime;        // next departure time
    int nextQueue;          // index of queue for next departure
 
    int shortest;           // index of shortest queue
    int shortestSize;       // size of shortest queue
    Customer rearCust;      // customer at rear of shortest queue
    int finishTime;         // calculated finish time for customer being enqueued

    // instantiate the queues
    for (int i = 0; i < numQueues; i++)
      queues[i] = new GlassQueue<Customer>();
 
    // set customer generator and get first customer
    custGen.reset();
    nextCust = custGen.nextCustomer();
    
    while (custOutCount < numCustomers)  // while still more customers to handle
    { 
      // get next arrival time
      if (custInCount != numCustomers) 
        nextArrTime = nextCust.getArrivalTime();
      else 
        nextArrTime = MAXTIME; 
 
      // get next departure time and set nextQueue
      nextDepTime = MAXTIME;
      nextQueue = -1;
      for (int i = 0; i < numQueues; i++)
        if (queues[i].size() != 0)
        {
          cust = queues[i].peekFront();
          if (cust.getFinishTime() < nextDepTime)
          {
            nextDepTime = cust.getFinishTime();
            nextQueue = i;
          }          
        }

      if (nextArrTime < nextDepTime)
      // handle customer arriving
      {
        // determine shortest queue
        shortest = 0;
        shortestSize = queues[0].size();
        longest=-1;
        longestSize=-1;
        //changed i from 1 to 0 to still provide longest when only 1 queue
        for (int i = 0; i < numQueues; i++)
        {
          //**NEW CODE**
          //determine longest
          if(queues[i].size()>longestSize){
           	longest=i;
           	longestSize=queues[i].size();
       	  }
          if (queues[i].size() < shortestSize)
          {
            shortest = i;
            shortestSize = queues[i].size();
          }
        }

        //**NEW CODE**
        // determine queue with shortest finish time
        shortestFinishTime=Integer.MAX_VALUE;
        for(int i=0;i<numQueues;i++){
        	if(queues[i].isEmpty()){
        		shortestFinishTimeQ=i;
        		if(!assignment&&debug)
        			System.out.println("Queue: "+(i+1)+" is empty");
        		break;
        	}
        	else{
        		rearCust = queues[i].peekRear();
        		finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
        		if(!assignment&&debug)
        			System.out.println("Queue: "+(i+1)+" FinishTime: "+finishTime);
        		if(finishTime<shortestFinishTime){
        			shortestFinishTimeQ=i;
        			shortestFinishTime=finishTime;
        		}
        	}
        }
        
        // determine the finish time ADDED code for different assignment method
        if(assignment){
        	if (shortestSize == 0)
        		finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
        	else
        	{
        		rearCust = queues[shortest].peekRear();
        		finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
        	}
        }
        else{
        	if(queues[shortestFinishTimeQ].isEmpty()){
        		finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
        	}
        	else{
        		rearCust = queues[shortestFinishTimeQ].peekRear();
        		finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
        	}
        }
    
        // set finish time and enqueue customer
        nextCust.setFinishTime(finishTime);
        //**NEW CODE**
        if(assignment){
          queues[shortest].enqueue(nextCust);
        }
        else{
          queues[shortestFinishTimeQ].enqueue(nextCust);
          if(debug)
        	  System.out.println("Queue selected: "+(shortestFinishTimeQ+1));
        }
        
        custInCount = custInCount + 1;
          
        // if needed, get next customer to enqueue
        if (custInCount < numCustomers)
          nextCust = custGen.nextCustomer();
      }
      else
      // handle customer leaving
      {
          cust = queues[nextQueue].dequeue();
          totWaitTime = totWaitTime + cust.getWaitTime();
          custOutCount = custOutCount + 1;
      }
    }  // end while
      
    avgWaitTime = totWaitTime/(float)numCustomers;
  }
}