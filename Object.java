/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 13 "model.ump"
// line 50 "model.ump"
public class Object
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Object Attributes
  private String name;

  //Object Associations
  private Message sentMessage;
  private Message receivedObject;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Object(String aName, Message aSentMessage, Message aReceivedObject)
  {
    name = aName;
    if (aSentMessage == null || aSentMessage.getSender() != null)
    {
      throw new RuntimeException("Unable to create Object due to aSentMessage. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sentMessage = aSentMessage;
    boolean didAddReceivedObject = setReceivedObject(aReceivedObject);
    if (!didAddReceivedObject)
    {
      throw new RuntimeException("Unable to create receiver due to receivedObject. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Object(String aName, String aNameForSentMessage, Message aReceivedObject)
  {
    name = aName;
    sentMessage = new Message(aNameForSentMessage, this);
    boolean didAddReceivedObject = setReceivedObject(aReceivedObject);
    if (!didAddReceivedObject)
    {
      throw new RuntimeException("Unable to create receiver due to receivedObject. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public Message getSentMessage()
  {
    return sentMessage;
  }
  /* Code from template association_GetOne */
  public Message getReceivedObject()
  {
    return receivedObject;
  }
  /* Code from template association_SetOneToMany */
  public boolean setReceivedObject(Message aReceivedObject)
  {
    boolean wasSet = false;
    if (aReceivedObject == null)
    {
      return wasSet;
    }

    Message existingReceivedObject = receivedObject;
    receivedObject = aReceivedObject;
    if (existingReceivedObject != null && !existingReceivedObject.equals(aReceivedObject))
    {
      existingReceivedObject.removeReceiver(this);
    }
    receivedObject.addReceiver(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Message existingSentMessage = sentMessage;
    sentMessage = null;
    if (existingSentMessage != null)
    {
      existingSentMessage.delete();
    }
    Message placeholderReceivedObject = receivedObject;
    this.receivedObject = null;
    if(placeholderReceivedObject != null)
    {
      placeholderReceivedObject.removeReceiver(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sentMessage = "+(getSentMessage()!=null?Integer.toHexString(System.identityHashCode(getSentMessage())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "receivedObject = "+(getReceivedObject()!=null?Integer.toHexString(System.identityHashCode(getReceivedObject())):"null");
  }
}