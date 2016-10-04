//----------------------------------------------------------------------
// LinkedStringLog.java       by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using a linked list 
// of LLStringNode to hold the log strings.
//----------------------------------------------------------------------

package ch02.stringLogs;

public class LinkedStringLog implements StringLogInterface 
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;

    while (node != null) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        return true;
      else
        node = node.getLink();
    }

   return false;
  }
  
  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }

  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";
    LLStringNode node;
    node = log;
    int count = 0;
    
    while (node != null)
    {
      count++;
      logString = logString + count + ". " + node.getInfo() + "\n";
      node = node.getLink();
    }
      
    return logString;
  }
  //Eric Meltzer GitGit
  //my methods
  
  //checks 'log' to see if null indicating no element insertion
  //return true if empty, else false
  //Postcondition - boolean returned
  public boolean isEmpty(){
	  if(log==null)
		  return true;
	  else
		  return false;
  }
  
  //traverses StringLog and increment count when 'element' is found
  //String element - string to be found
  //return an int count
  //Postcondition - int returned
  public int howMany(String element){
	  LLStringNode node;
	  int count=0;
	  node=log;
	  while(node!=null)
	  {
		  if(element.equalsIgnoreCase(node.getInfo()))
		  {
			  count++;
		  }
		  node=node.getLink();
	  }
	  return count;
  }
  
  //check if 'element' is in StringLog and if not insert it
  //String element - string to be inserted
  //return a boolean representing successful (or not) insertion
  //invokes contains(String element) and insert(String element) methods
  //Postcondition - boolean returned
  public boolean uniqInsert(String element){
	  if(this.contains(element)){
		  return false;
	  }
	  else
	  {
		  this.insert(element);
		  return true;
	  }
  }
  
  //set 'smallest' to top LLStringNode's 'info' then traverse StringLog
  //reassign 'smallest' if current node's 'info' is smaller lexicographically
  //return String representing smallest
  //Precondition: this StringLog is not empty.
  //Postcondition: String returned
  public String smallest(){
	  String smallest;
	  LLStringNode node;
	  node=log;
	  smallest=log.getInfo();
	  while(node!=null){
		  if(node.getInfo().compareToIgnoreCase(smallest)<0){
			  smallest=node.getInfo();
		  }
		  node=node.getLink();
	  }
	  return smallest;
  }
  
}