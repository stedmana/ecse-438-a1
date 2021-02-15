/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



/**
 * operand exists of one or more messages connected through fragment
 */
// line 36 "model.ump"
// line 76 "model.ump"
public class Operand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Operand Associations
  private OpCondition opCondition;
  private ParallelFragment parallelFragment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Operand(OpCondition aOpCondition, ParallelFragment aParallelFragment)
  {
    if (aOpCondition == null || aOpCondition.getOperand() != null)
    {
      throw new RuntimeException("Unable to create Operand due to aOpCondition. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    opCondition = aOpCondition;
    boolean didAddParallelFragment = setParallelFragment(aParallelFragment);
    if (!didAddParallelFragment)
    {
      throw new RuntimeException("Unable to create operand due to parallelFragment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Operand(AlternativeFragment aAlternativeFragmentForOpCondition, ParallelFragment aParallelFragment)
  {
    opCondition = new OpCondition(this, aAlternativeFragmentForOpCondition);
    boolean didAddParallelFragment = setParallelFragment(aParallelFragment);
    if (!didAddParallelFragment)
    {
      throw new RuntimeException("Unable to create operand due to parallelFragment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public OpCondition getOpCondition()
  {
    return opCondition;
  }
  /* Code from template association_GetOne */
  public ParallelFragment getParallelFragment()
  {
    return parallelFragment;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setParallelFragment(ParallelFragment aParallelFragment)
  {
    boolean wasSet = false;
    //Must provide parallelFragment to operand
    if (aParallelFragment == null)
    {
      return wasSet;
    }

    if (parallelFragment != null && parallelFragment.numberOfOperands() <= ParallelFragment.minimumNumberOfOperands())
    {
      return wasSet;
    }

    ParallelFragment existingParallelFragment = parallelFragment;
    parallelFragment = aParallelFragment;
    if (existingParallelFragment != null && !existingParallelFragment.equals(aParallelFragment))
    {
      boolean didRemove = existingParallelFragment.removeOperand(this);
      if (!didRemove)
      {
        parallelFragment = existingParallelFragment;
        return wasSet;
      }
    }
    parallelFragment.addOperand(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    OpCondition existingOpCondition = opCondition;
    opCondition = null;
    if (existingOpCondition != null)
    {
      existingOpCondition.delete();
    }
    ParallelFragment placeholderParallelFragment = parallelFragment;
    this.parallelFragment = null;
    if(placeholderParallelFragment != null)
    {
      placeholderParallelFragment.removeOperand(this);
    }
  }

}