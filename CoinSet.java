import javax.lang.model.element.NestingKind;
import java.util.ArrayList;

/**
   A set of coins.
*/
public class CoinSet
{  
   private ArrayList<Coin> set;

   /**
      Constructs a CoinSet object.
   */
   public CoinSet()
   {  
      set = new ArrayList<Coin>();
   }

   public void addCoin(Coin c){
      set.add(c);
   }

   public double getValue(){
      double total = 0;
      for(Coin c : set){
         total += c.getValue();
      }
      return total;
   }

   public String toString(){
      StringBuilder x = new StringBuilder();
       for (Coin coin : set) {
           x.append(coin);
       }
       return x.toString();
   }

   public void removeAllCoins(){
       set = new ArrayList<>();
   }

   //ADD REMAINING CODE HERE
}