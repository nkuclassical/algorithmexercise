package design;

import java.util.Iterator;

public class implements Iterator<Integer> {
	Integer peekValue;
//	boolean hasPeek;
	Iterator<Integer>it;
	public PeekIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it=iterator;
	    if(it.hasNext()){
	    	peekValue=it.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
//        if(!hasPeek){
//        	peekValue=it.next();
//        	hasPeek=true;
//        }
//        return peekValue;
		return peekValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
//	    if(!hasPeek){
//	    	return it.next();
//	    }
//	    Integer ret=peekValue;
//	    hasPeek=false;
//	    peekValue=null;
//	    return ret;
		int ret=peekValue;
		peekValue=it.hasNext()?it.next():null;
		return ret;
	}

	@Override
	public boolean hasNext() {
//	    return hasPeek||it.hasNext();
		return peekValue!=null;
	}
}
