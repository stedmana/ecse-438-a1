/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 27 "model.ump"
// line 66 "model.ump"
public class OpCondition
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpCondition Associations
  private Operand operand;
  private AlternativeFragment alternativeFragment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OpCondition(Operand aOperand, AlternativeFragment aAlternativeFragment)
  {
    if (aOperand == null || aOperand.getOpCondition() != null)
    {
      throw new RuntimeException("Unable to create OpCondition due to aOperand. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    operand = aOperand;
    boolean didAddAlternativeFragment = setAlternativeFragment(aAlternativeFragment);
    if (!didAddAlternativeFragment)
    {
      throw new RuntimeException("Unable to create ConditionAndOp due to alternativeFragment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public OpCondition(ParallelFragment aParallelFragmentForOperand, AlternativeFragment aAlternativeFragment)
  {
    operand = new Operand(this, aParallelFragmentForOperand);
    boolean didAddAlternativeFragment = setAlternativeFragment(aAlternativeFragment);
    if (!didAddAlternativeFragment)
    {
      throw new RuntimeException("Unable to create ConditionAndOp due to alternativeFragment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Operand getOperand()
  {
    return operand;
  }
  /* Code from template association_GetOne */
  public AlternativeFragment getAlternativeFragment()
  {
    return alternativeFragment;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setAlternativeFragment(AlternativeFragment aAlternativeFragment)
  {
    boolean wasSet = false;
    //Must provide alternativeFragment to ConditionAndOp
    if (aAlternativeFragment == null)
    {
      return wasSet;
    }

    if (alternativeFragment != null && alternativeFragment.numberOfConditionAndOp() <= AlternativeFragment.minimumNumberOfConditionAndOp())
    {
      return wasSet;
    }

    AlternativeFragment existingAlternativeFragment = alternativeFragment;
    alternativeFragment = aAlternativeFragment;
    if (existingAlternativeFragment != null && !existingAlternativeFragment.equals(aAlternativeFragment))
    {
      boolean didRemove = existingAlternativeFragment.removeConditionAndOp(this);
      if (!didRemove)
      {
        alternativeFragment = existingAlternativeFragment;
        return wasSet;
      }
    }
    alternativeFragment.addConditionAndOp(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Operand existingOperand = operand;
    operand = null;
    if (existingOperand != null)
    {
      existingOperand.delete();
    }
    AlternativeFragment placeholderAlternativeFragment = alternativeFragment;
    this.alternativeFragment = null;
    if(placeholderAlternativeFragment != null)
    {
      placeholderAlternativeFragment.removeConditionAndOp(this);
    }
  }

}