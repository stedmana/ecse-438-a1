/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 18 "model.ump"
// line 55 "model.ump"
public class Fragment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Fragment Associations
  private List<Message> before;
  private List<Message> after;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Fragment(Message[] allBefore, Message[] allAfter)
  {
    before = new ArrayList<Message>();
    boolean didAddBefore = setBefore(allBefore);
    if (!didAddBefore)
    {
      throw new RuntimeException("Unable to create Fragment, must have at least 1 before. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    after = new ArrayList<Message>();
    boolean didAddAfter = setAfter(allAfter);
    if (!didAddAfter)
    {
      throw new RuntimeException("Unable to create Fragment, must have at least 1 after. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Message getBefore(int index)
  {
    Message aBefore = before.get(index);
    return aBefore;
  }

  public List<Message> getBefore()
  {
    List<Message> newBefore = Collections.unmodifiableList(before);
    return newBefore;
  }

  public int numberOfBefore()
  {
    int number = before.size();
    return number;
  }

  public boolean hasBefore()
  {
    boolean has = before.size() > 0;
    return has;
  }

  public int indexOfBefore(Message aBefore)
  {
    int index = before.indexOf(aBefore);
    return index;
  }
  /* Code from template association_GetMany */
  public Message getAfter(int index)
  {
    Message aAfter = after.get(index);
    return aAfter;
  }

  public List<Message> getAfter()
  {
    List<Message> newAfter = Collections.unmodifiableList(after);
    return newAfter;
  }

  public int numberOfAfter()
  {
    int number = after.size();
    return number;
  }

  public boolean hasAfter()
  {
    boolean has = after.size() > 0;
    return has;
  }

  public int indexOfAfter(Message aAfter)
  {
    int index = after.indexOf(aAfter);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfBeforeValid()
  {
    boolean isValid = numberOfBefore() >= minimumNumberOfBefore();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBefore()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBefore(Message aBefore)
  {
    boolean wasAdded = false;
    if (before.contains(aBefore)) { return false; }
    before.add(aBefore);
    if (aBefore.indexOfBeforeFragment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBefore.addBeforeFragment(this);
      if (!wasAdded)
      {
        before.remove(aBefore);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeBefore(Message aBefore)
  {
    boolean wasRemoved = false;
    if (!before.contains(aBefore))
    {
      return wasRemoved;
    }

    if (numberOfBefore() <= minimumNumberOfBefore())
    {
      return wasRemoved;
    }

    int oldIndex = before.indexOf(aBefore);
    before.remove(oldIndex);
    if (aBefore.indexOfBeforeFragment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBefore.removeBeforeFragment(this);
      if (!wasRemoved)
      {
        before.add(oldIndex,aBefore);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setBefore(Message... newBefore)
  {
    boolean wasSet = false;
    ArrayList<Message> verifiedBefore = new ArrayList<Message>();
    for (Message aBefore : newBefore)
    {
      if (verifiedBefore.contains(aBefore))
      {
        continue;
      }
      verifiedBefore.add(aBefore);
    }

    if (verifiedBefore.size() != newBefore.length || verifiedBefore.size() < minimumNumberOfBefore())
    {
      return wasSet;
    }

    ArrayList<Message> oldBefore = new ArrayList<Message>(before);
    before.clear();
    for (Message aNewBefore : verifiedBefore)
    {
      before.add(aNewBefore);
      if (oldBefore.contains(aNewBefore))
      {
        oldBefore.remove(aNewBefore);
      }
      else
      {
        aNewBefore.addBeforeFragment(this);
      }
    }

    for (Message anOldBefore : oldBefore)
    {
      anOldBefore.removeBeforeFragment(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBeforeAt(Message aBefore, int index)
  {  
    boolean wasAdded = false;
    if(addBefore(aBefore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBefore()) { index = numberOfBefore() - 1; }
      before.remove(aBefore);
      before.add(index, aBefore);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBeforeAt(Message aBefore, int index)
  {
    boolean wasAdded = false;
    if(before.contains(aBefore))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBefore()) { index = numberOfBefore() - 1; }
      before.remove(aBefore);
      before.add(index, aBefore);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBeforeAt(aBefore, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfAfterValid()
  {
    boolean isValid = numberOfAfter() >= minimumNumberOfAfter();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAfter()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAfter(Message aAfter)
  {
    boolean wasAdded = false;
    if (after.contains(aAfter)) { return false; }
    after.add(aAfter);
    if (aAfter.indexOfAfterFragment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAfter.addAfterFragment(this);
      if (!wasAdded)
      {
        after.remove(aAfter);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeAfter(Message aAfter)
  {
    boolean wasRemoved = false;
    if (!after.contains(aAfter))
    {
      return wasRemoved;
    }

    if (numberOfAfter() <= minimumNumberOfAfter())
    {
      return wasRemoved;
    }

    int oldIndex = after.indexOf(aAfter);
    after.remove(oldIndex);
    if (aAfter.indexOfAfterFragment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAfter.removeAfterFragment(this);
      if (!wasRemoved)
      {
        after.add(oldIndex,aAfter);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setAfter(Message... newAfter)
  {
    boolean wasSet = false;
    ArrayList<Message> verifiedAfter = new ArrayList<Message>();
    for (Message aAfter : newAfter)
    {
      if (verifiedAfter.contains(aAfter))
      {
        continue;
      }
      verifiedAfter.add(aAfter);
    }

    if (verifiedAfter.size() != newAfter.length || verifiedAfter.size() < minimumNumberOfAfter())
    {
      return wasSet;
    }

    ArrayList<Message> oldAfter = new ArrayList<Message>(after);
    after.clear();
    for (Message aNewAfter : verifiedAfter)
    {
      after.add(aNewAfter);
      if (oldAfter.contains(aNewAfter))
      {
        oldAfter.remove(aNewAfter);
      }
      else
      {
        aNewAfter.addAfterFragment(this);
      }
    }

    for (Message anOldAfter : oldAfter)
    {
      anOldAfter.removeAfterFragment(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAfterAt(Message aAfter, int index)
  {  
    boolean wasAdded = false;
    if(addAfter(aAfter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfter()) { index = numberOfAfter() - 1; }
      after.remove(aAfter);
      after.add(index, aAfter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAfterAt(Message aAfter, int index)
  {
    boolean wasAdded = false;
    if(after.contains(aAfter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfter()) { index = numberOfAfter() - 1; }
      after.remove(aAfter);
      after.add(index, aAfter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAfterAt(aAfter, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Message> copyOfBefore = new ArrayList<Message>(before);
    before.clear();
    for(Message aBefore : copyOfBefore)
    {
      aBefore.removeBeforeFragment(this);
    }
    ArrayList<Message> copyOfAfter = new ArrayList<Message>(after);
    after.clear();
    for(Message aAfter : copyOfAfter)
    {
      aAfter.removeAfterFragment(this);
    }
  }

}