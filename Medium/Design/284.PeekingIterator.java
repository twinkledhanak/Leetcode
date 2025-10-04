
import java.util.NoSuchElementException;

/**
Challenge: increment iterator for next(); but do NOT increment iterator for peek()
Higher Level Intuition: [1,2,3]

peek() - [we have to increment iterator once using next()]
1. call next() [always check hasNext() before next()]
    -> gives 1
    -> store temp=1
return temp
Also, next() returned 1 and now points to 2 since pointer moved forward

next() -
We still have to return 1, even though it points at 2
1. check the value if temp exists
    -> If yes, return that temp
    -> set peek() as null
2. Temp does not exist
    -> always check hasNext() before next()
    -> return next()    

*/



class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter; /// Global Iterator
    private Integer peekedValue = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
    }

    public Integer peek() {
        /* If there's not already a peeked value, get one out and store
         * it in the peekedValue variable. We aren't told what to do if
         * the iterator is actually empty -- here I have thrown an exception
         * but in an interview you should definitely ask! This is the kind of
         * thing they expect you to ask about. */

         // **************************
         // Everytime we call next(), we also have to call hasNext()
        if (peekedValue == null) {
            if (!iter.hasNext()) {
                throw new NoSuchElementException();
            }
            peekedValue = iter.next();
        }
        return peekedValue;
    }

    @Override
    public Integer next() {
        /* Firstly, we need to check if we have a value already
         * stored in the peekedValue variable. If we do, we need to
         * return it and also set peekedValue to null so that the value
         * isn't returned again. */
        if (peekedValue != null) {
            Integer toReturn = peekedValue;
            peekedValue = null;
            return toReturn;
        }
        /* As per the Java Iterator specs, we should throw a NoSuchElementException
         * if the next element doesn't exist. */

         // **************************
        if (!iter.hasNext()) {
            throw new NoSuchElementException();
        }
        /* Otherwise, we need to return a new value. */
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        /* If there's a value waiting in peekedValue, or if there are values
         * remaining in the iterator, we should return true. */
        return peekedValue != null || iter.hasNext();
    }
}
