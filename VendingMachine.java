
import java.util.ArrayList;

/**
   A vending machine.
*/
public class VendingMachine
{  
   private ArrayList<Product> products;
   public CoinSet coins;
   public CoinSet currentCoins;

   /**
      Constructs a VendingMachine object.
   */
   public VendingMachine()
   { 
      products = new ArrayList<Product>();
      coins = new CoinSet();
      currentCoins = new CoinSet();
   }

   public void addProduct(Product product, int quantity){
      for(int i = 0;i<quantity;i++){
         products.add(product);
      }
   }
   public Product[] getProductTypes(){
      ArrayList<Product> types = new ArrayList<>();

       for (Product product : products)
           if (!types.contains(product)) types.add(product);
       Product[] list = new Product[types.size()];
           for(int i =0; i<list.length;i++)
              list[i] = types.get(i);

      return list;
   }
   public void addCoin(Coin coin) {
      currentCoins.addCoin(coin);
   }
   public double removeMoney(){
      double value = currentCoins.getValue();
      currentCoins.removeAllCoins();
      return value;
   }
   public void buyProduct(Product product) {
         for (int i = 0; i < products.size(); i++) {
            if (product.equals(products.get(i))) {
               if (product.getPrice() <= currentCoins.getValue()) {
                  products.remove(i);
                  currentCoins.removeAllCoins();
                  return;
               } else {
                  throw new VendingException("Insufficient money");
               }
            }
         }
         throw new VendingException("No Such Product");
   }
}