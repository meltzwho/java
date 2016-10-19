//----------------------------------------------------------------------------
// LLStringNode.java            by Dale/Joyce/Weems                  Chapter 2
//
// Implements String nodes for a Linked List.
//----------------------------------------------------------------------------

package ch02.stringLogs;

public class LLStringNode<T> 
{
  private T info;
  private LLStringNode<T> link;
  
  public LLStringNode(T info)
  {
    this.info = info;
    link = null;
  }
 
  public void setInfo(T info)
  // Sets info string of this LLStringNode.
  {
    this.info = info;
  }

  public T getInfo()
  // Returns info string of this LLStringNode.
  {
    return info;
  }
 
  public void setLink(LLStringNode<T> link)
  // Sets link of this LLStringNode.
  {
    this.link = link;
  }

  public LLStringNode<T> getLink()
  // Returns link of this LLStringNode.
  {
    return link;
  }
}
 
 