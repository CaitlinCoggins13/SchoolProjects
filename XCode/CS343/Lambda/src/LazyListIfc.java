import java.util.ArrayList;

public interface LazyListIfc<T> 
{
      /**
       * @return the first value in the lazy list
       */
      public T lazyFirst();
      
      /**
       * @return the list with the first value removed
       */
      public LazyListIfc<T> lazyRest();
      
      /**
       * Return the first part of a lazy list
       * @param howMany the number of values from the lazy list to return
       * @return the values at the start of the list as an ArrayList
       */
      public ArrayList<T> take(int howMany); 
}
