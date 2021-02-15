/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 43 "model.ump"
public class Message
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Message Attributes
  private String name;

  //Message Associations
  private Object sender;
  private List<Object> receiver;
  private List<Fragment> beforeFragment;
  private List<Fragment> afterFragment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Message(String aName, Object aSender)
  {
    name = aName;
    if (aSender == null || aSender.getSentMessage() != null)
    {
      throw new RuntimeException("Unable to create Message due to aSender. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sender = aSender;
    receiver = new ArrayList<Object>();
    beforeFragment = new ArrayList<Fragment>();
    afterFragment = new ArrayList<Fragment>();
  }

  public Message(String aName, String aNameForSender, Message aReceivedObjectForSender)
  {
    name = aName;
    sender = new Object(aNameForSender, this, aReceivedObjectForSender);
    receiver = new ArrayList<Object>();
    beforeFragment = new ArrayList<Fragment>();
    afterFragment = new ArrayList<Fragment>();
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
  public Object getSender()
  {
    return sender;
  }
  /* Code from template association_GetMany */
  public Object getReceiver(int index)
  {
    Object aReceiver = receiver.get(index);
    return aReceiver;
  }

  public List<Object> getReceiver()
  {
    List<Object> newReceiver = Collections.unmodifiableList(receiver);
    return newReceiver;
  }

  public int numberOfReceiver()
  {
    int number = receiver.size();
    return number;
  }

  public boolean hasReceiver()
  {
    boolean has = receiver.size() > 0;
    return has;
  }

  public int indexOfReceiver(Object aReceiver)
  {
    int index = receiver.indexOf(aReceiver);
    return index;
  }
  /* Code from template association_GetMany */
  public Fragment getBeforeFragment(int index)
  {
    Fragment aBeforeFragment = beforeFragment.get(index);
    return aBeforeFragment;
  }

  public List<Fragment> getBeforeFragment()
  {
    List<Fragment> newBeforeFragment = Collections.unmodifiableList(beforeFragment);
    return newBeforeFragment;
  }

  public int numberOfBeforeFragment()
  {
    int number = beforeFragment.size();
    return number;
  }

  public boolean hasBeforeFragment()
  {
    boolean has = beforeFragment.size() > 0;
    return has;
  }

  public int indexOfBeforeFragment(Fragment aBeforeFragment)
  {
    int index = beforeFragment.indexOf(aBeforeFragment);
    return index;
  }
  /* Code from template association_GetMany */
  public Fragment getAfterFragment(int index)
  {
    Fragment aAfterFragment = afterFragment.get(index);
    return aAfterFragment;
  }

  public List<Fragment> getAfterFragment()
  {
    List<Fragment> newAfterFragment = Collections.unmodifiableList(afterFragment);
    return newAfterFragment;
  }

  public int numberOfAfterFragment()
  {
    int number = afterFragment.size();
    return number;
  }

  public boolean hasAfterFragment()
  {
    boolean has = afterFragment.size() > 0;
    return has;
  }

  public int indexOfAfterFragment(Fragment aAfterFragment)
  {
    int index = afterFragment.indexOf(aAfterFragment);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReceiver()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Object addReceiver(String aName, Message aSentMessage)
  {
    return new Object(aName, aSentMessage, this);
  }

  public boolean addReceiver(Object aReceiver)
  {
    boolean wasAdded = false;
    if (receiver.contains(aReceiver)) { return false; }
    Message existingReceivedObject = aReceiver.getReceivedObject();
    boolean isNewReceivedObject = existingReceivedObject != null && !this.equals(existingReceivedObject);
    if (isNewReceivedObject)
    {
      aReceiver.setReceivedObject(this);
    }
    else
    {
      receiver.add(aReceiver);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReceiver(Object aReceiver)
  {
    boolean wasRemoved = false;
    //Unable to remove aReceiver, as it must always have a receivedObject
    if (!this.equals(aReceiver.getReceivedObject()))
    {
      receiver.remove(aReceiver);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReceiverAt(Object aReceiver, int index)
  {  
    boolean wasAdded = false;
    if(addReceiver(aReceiver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceiver()) { index = numberOfReceiver() - 1; }
      receiver.remove(aReceiver);
      receiver.add(index, aReceiver);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReceiverAt(Object aReceiver, int index)
  {
    boolean wasAdded = false;
    if(receiver.contains(aReceiver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceiver()) { index = numberOfReceiver() - 1; }
      receiver.remove(aReceiver);
      receiver.add(index, aReceiver);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReceiverAt(aReceiver, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBeforeFragment()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBeforeFragment(Fragment aBeforeFragment)
  {
    boolean wasAdded = false;
    if (beforeFragment.contains(aBeforeFragment)) { return false; }
    beforeFragment.add(aBeforeFragment);
    if (aBeforeFragment.indexOfBefore(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBeforeFragment.addBefore(this);
      if (!wasAdded)
      {
        beforeFragment.remove(aBeforeFragment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBeforeFragment(Fragment aBeforeFragment)
  {
    boolean wasRemoved = false;
    if (!beforeFragment.contains(aBeforeFragment))
    {
      return wasRemoved;
    }

    int oldIndex = beforeFragment.indexOf(aBeforeFragment);
    beforeFragment.remove(oldIndex);
    if (aBeforeFragment.indexOfBefore(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBeforeFragment.removeBefore(this);
      if (!wasRemoved)
      {
        beforeFragment.add(oldIndex,aBeforeFragment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBeforeFragmentAt(Fragment aBeforeFragment, int index)
  {  
    boolean wasAdded = false;
    if(addBeforeFragment(aBeforeFragment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBeforeFragment()) { index = numberOfBeforeFragment() - 1; }
      beforeFragment.remove(aBeforeFragment);
      beforeFragment.add(index, aBeforeFragment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBeforeFragmentAt(Fragment aBeforeFragment, int index)
  {
    boolean wasAdded = false;
    if(beforeFragment.contains(aBeforeFragment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBeforeFragment()) { index = numberOfBeforeFragment() - 1; }
      beforeFragment.remove(aBeforeFragment);
      beforeFragment.add(index, aBeforeFragment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBeforeFragmentAt(aBeforeFragment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAfterFragment()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAfterFragment(Fragment aAfterFragment)
  {
    boolean wasAdded = false;
    if (afterFragment.contains(aAfterFragment)) { return false; }
    afterFragment.add(aAfterFragment);
    if (aAfterFragment.indexOfAfter(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAfterFragment.addAfter(this);
      if (!wasAdded)
      {
        afterFragment.remove(aAfterFragment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeAfterFragment(Fragment aAfterFragment)
  {
    boolean wasRemoved = false;
    if (!afterFragment.contains(aAfterFragment))
    {
      return wasRemoved;
    }

    int oldIndex = afterFragment.indexOf(aAfterFragment);
    afterFragment.remove(oldIndex);
    if (aAfterFragment.indexOfAfter(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAfterFragment.removeAfter(this);
      if (!wasRemoved)
      {
        afterFragment.add(oldIndex,aAfterFragment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAfterFragmentAt(Fragment aAfterFragment, int index)
  {  
    boolean wasAdded = false;
    if(addAfterFragment(aAfterFragment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfterFragment()) { index = numberOfAfterFragment() - 1; }
      afterFragment.remove(aAfterFragment);
      afterFragment.add(index, aAfterFragment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAfterFragmentAt(Fragment aAfterFragment, int index)
  {
    boolean wasAdded = false;
    if(afterFragment.contains(aAfterFragment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfterFragment()) { index = numberOfAfterFragment() - 1; }
      afterFragment.remove(aAfterFragment);
      afterFragment.add(index, aAfterFragment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAfterFragmentAt(aAfterFragment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Object existingSender = sender;
    sender = null;
    if (existingSender != null)
    {
      existingSender.delete();
    }
    for(int i=receiver.size(); i > 0; i--)
    {
      Object aReceiver = receiver.get(i - 1);
      aReceiver.delete();
    }
    ArrayList<Fragment> copyOfBeforeFragment = new ArrayList<Fragment>(beforeFragment);
    beforeFragment.clear();
    for(Fragment aBeforeFragment : copyOfBeforeFragment)
    {
      if (aBeforeFragment.numberOfBefore() <= Fragment.minimumNumberOfBefore())
      {
        aBeforeFragment.delete();
      }
      else
      {
        aBeforeFragment.removeBefore(this);
      }
    }
    ArrayList<Fragment> copyOfAfterFragment = new ArrayList<Fragment>(afterFragment);
    afterFragment.clear();
    for(Fragment aAfterFragment : copyOfAfterFragment)
    {
      if (aAfterFragment.numberOfAfter() <= Fragment.minimumNumberOfAfter())
      {
        aAfterFragment.delete();
      }
      else
      {
        aAfterFragment.removeAfter(this);
      }
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sender = "+(getSender()!=null?Integer.toHexString(System.identityHashCode(getSender())):"null");
  }
}