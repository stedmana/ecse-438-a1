/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 22 "model.ump"
// line 61 "model.ump"
public class AlternativeFragment extends Fragment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AlternativeFragment Associations
  private List<OpCondition> ConditionAndOp;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AlternativeFragment(Message[] allBefore, Message[] allAfter)
  {
    super(allBefore, allAfter);
    ConditionAndOp = new ArrayList<OpCondition>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public OpCondition getConditionAndOp(int index)
  {
    OpCondition aConditionAndOp = ConditionAndOp.get(index);
    return aConditionAndOp;
  }

  public List<OpCondition> getConditionAndOp()
  {
    List<OpCondition> newConditionAndOp = Collections.unmodifiableList(ConditionAndOp);
    return newConditionAndOp;
  }

  public int numberOfConditionAndOp()
  {
    int number = ConditionAndOp.size();
    return number;
  }

  public boolean hasConditionAndOp()
  {
    boolean has = ConditionAndOp.size() > 0;
    return has;
  }

  public int indexOfConditionAndOp(OpCondition aConditionAndOp)
  {
    int index = ConditionAndOp.indexOf(aConditionAndOp);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfConditionAndOpValid()
  {
    boolean isValid = numberOfConditionAndOp() >= minimumNumberOfConditionAndOp();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfConditionAndOp()
  {
    return 2;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public OpCondition addConditionAndOp(Operand aOperand)
  {
    OpCondition aNewConditionAndOp = new OpCondition(aOperand, this);
    return aNewConditionAndOp;
  }

  public boolean addConditionAndOp(OpCondition aConditionAndOp)
  {
    boolean wasAdded = false;
    if (ConditionAndOp.contains(aConditionAndOp)) { return false; }
    AlternativeFragment existingAlternativeFragment = aConditionAndOp.getAlternativeFragment();
    boolean isNewAlternativeFragment = existingAlternativeFragment != null && !this.equals(existingAlternativeFragment);

    if (isNewAlternativeFragment && existingAlternativeFragment.numberOfConditionAndOp() <= minimumNumberOfConditionAndOp())
    {
      return wasAdded;
    }
    if (isNewAlternativeFragment)
    {
      aConditionAndOp.setAlternativeFragment(this);
    }
    else
    {
      ConditionAndOp.add(aConditionAndOp);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConditionAndOp(OpCondition aConditionAndOp)
  {
    boolean wasRemoved = false;
    //Unable to remove aConditionAndOp, as it must always have a alternativeFragment
    if (this.equals(aConditionAndOp.getAlternativeFragment()))
    {
      return wasRemoved;
    }

    //alternativeFragment already at minimum (2)
    if (numberOfConditionAndOp() <= minimumNumberOfConditionAndOp())
    {
      return wasRemoved;
    }

    ConditionAndOp.remove(aConditionAndOp);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addConditionAndOpAt(OpCondition aConditionAndOp, int index)
  {  
    boolean wasAdded = false;
    if(addConditionAndOp(aConditionAndOp))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConditionAndOp()) { index = numberOfConditionAndOp() - 1; }
      ConditionAndOp.remove(aConditionAndOp);
      ConditionAndOp.add(index, aConditionAndOp);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConditionAndOpAt(OpCondition aConditionAndOp, int index)
  {
    boolean wasAdded = false;
    if(ConditionAndOp.contains(aConditionAndOp))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConditionAndOp()) { index = numberOfConditionAndOp() - 1; }
      ConditionAndOp.remove(aConditionAndOp);
      ConditionAndOp.add(index, aConditionAndOp);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConditionAndOpAt(aConditionAndOp, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=ConditionAndOp.size(); i > 0; i--)
    {
      OpCondition aConditionAndOp = ConditionAndOp.get(i - 1);
      aConditionAndOp.delete();
    }
    super.delete();
  }

}