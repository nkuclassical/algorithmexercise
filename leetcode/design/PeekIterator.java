package design;

import java.util.Iterator;

public class PeekIterator implements Iterator<Integer> {
	Integer peekValue;
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
		return peekValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int ret=peekValue;
		peekValue=it.hasNext()?it.next():null;
		return ret;
	}

	@Override
	public boolean hasNext() {
		return peekValue!=null;
	}
}
