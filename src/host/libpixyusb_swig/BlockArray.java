/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class BlockArray {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected BlockArray(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(BlockArray obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pixyJNI.delete_BlockArray(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public BlockArray(int nelements) {
    this(pixyJNI.new_BlockArray(nelements), true);
  }

  public Block getitem(int index) {
    return new Block(pixyJNI.BlockArray_getitem(swigCPtr, this, index), true);
  }

  public void setitem(int index, Block value) {
    pixyJNI.BlockArray_setitem(swigCPtr, this, index, Block.getCPtr(value), value);
  }

  public Block cast() {
    long cPtr = pixyJNI.BlockArray_cast(swigCPtr, this);
    return (cPtr == 0) ? null : new Block(cPtr, false);
  }

  public static BlockArray frompointer(Block t) {
    long cPtr = pixyJNI.BlockArray_frompointer(Block.getCPtr(t), t);
    return (cPtr == 0) ? null : new BlockArray(cPtr, false);
  }

}
