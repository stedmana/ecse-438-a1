/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 31 "model.ump"
// line 71 "model.ump"
public class ParallelFragment extends Fragment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParallelFragment Associations
  private List<Operand> operands;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParallelFragment(Message[] allBefore, Message[] allAfter)
  {
    super(allBefore, allAfter);
    operands = new ArrayList<Operand>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Operand getOperand(int index)
  {
    Operand aOperand = operands.get(index);
    return aOperand;
  }

  public List<Operand> getOperands()
  {
    List<Operand> newOperands = Collections.unmodifiableList(operands);
    return newOperands;
  }

  public int numberOfOperands()
  {
    int number = operands.size();
    return number;
  }

  public boolean hasOperands()
  {
    boolean has = operands.size() > 0;
    return has;
  }

  public int indexOfOperand(Operand aOperand)
  {
    int index = operands.indexOf(aOperand);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfOperandsValid()
  {
    boolean isValid = numberOfOperands() >= minimumNumberOfOperands();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOperands()
  {
    return 2;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Operand addOperand(OpCondition aOpCondition)
  {
    Operand aNewOperand = new Operand(aOpCondition, this);
    return aNewOperand;
  }

  public boolean addOperand(Operand aOperand)
  {
    boolean wasAdded = false;
    if (operands.contains(aOperand)) { return false; }
    ParallelFragment existingParallelFragment = aOperand.getParallelFragment();
    boolean isNewParallelFragment = existingParallelFragment != null && !this.equals(existingParallelFragment);

    if (isNewParallelFragment && existingParallelFragment.numberOfOperands() <= minimumNumberOfOperands())
    {
      return wasAdded;
    }
    if (isNewParallelFragment)
    {
      aOperand.setParallelFragment(this);
    }
    else
    {
      operands.add(aOperand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOperand(Operand aOperand)
  {
    boolean wasRemoved = false;
    //Unable to remove aOperand, as it must always have a parallelFragment
    if (this.equals(aOperand.getParallelFragment()))
    {
      return wasRemoved;
    }

    //parallelFragment already at minimum (2)
    if (numberOfOperands() <= minimumNumberOfOperands())
    {
      return wasRemoved;
    }

    operands.remove(aOperand);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOperandAt(Operand aOperand, int index)
  {  
    boolean wasAdded = false;
    if(addOperand(aOperand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperands()) { index = numberOfOperands() - 1; }
      operands.remove(aOperand);
      operands.add(index, aOperand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOperandAt(Operand aOperand, int index)
  {
    boolean wasAdded = false;
    if(operands.contains(aOperand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperands()) { index = numberOfOperands() - 1; }
      operands.remove(aOperand);
      operands.add(index, aOperand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOperandAt(aOperand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=operands.size(); i > 0; i--)
    {
      Operand aOperand = operands.get(i - 1);
      aOperand.delete();
    }
    super.delete();
  }

}