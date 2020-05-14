package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuspectIterator implements Iterator<Suspect> {
    Suspect suspect;
    Iterator<? extends  Suspect> iterator;
    SearchStrategy searchStrategy;

    public SuspectIterator(Iterator<? extends  Suspect> iterator, SearchStrategy searchStrategy){
        this.iterator=iterator;
        this.searchStrategy =searchStrategy;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()){
            Suspect tempSuspect = iterator.next();
            if(searchStrategy.filter(tempSuspect)&& tempSuspect.canBeSuspected()){
                suspect = tempSuspect;
                return true;
            }
        }
        return false;
    }

    @Override
    public Suspect next() {
        suspect=iterator.next();
        if(suspect != null) {
            return suspect;
        }
        throw new NoSuchElementException("There is no element");
    }
}
