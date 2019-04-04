/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
   for insanesnackbar
*/

public class Vendor
{
  // Fields:
	
  private int stock;
  private int deposit = 0;
  private int price;
  private int change = 0;

  //  Constructor
  //  Parameters:
  //    int price of a single item in cents
  //    int number of items to place in stock
  public Vendor(int price, int n)
  {
    this.price = price;
    stock = n;
  }

  //  Sets the quantity of items in stock.
  //  Parameters:
  //    int number of items to place in stock
  //  Return:
  //    None
  public void setStock(int n)
  {
    stock = n;
  }

  //  Returns the number of items currently in stock.
  //  Parameters:
  //    None
  //  Return:
  //    int number of items currently in stock
  public int getStock()
  {
    return stock;
  }

  //  Adds a specified amount (in cents) to the deposited amount.
  //  Parameters:
  //    int number of cents to add to the deposit
  //  Return:
  //    None
  public void addMoney(int amount)
  {
    deposit += amount;
  }

  //  Returns the currently deposited amount (in cents).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current deposit
  public int getDeposit()
  {
    return deposit;
  }

  //  Implements a sale.  If there are items in stock and
  //  the deposited amount is greater than or equal to
  //  the single item price, then adjusts the stock
  //  and calculates and sets change and returns true;
  //  otherwise refunds the whole deposit (moves it into change)
  //  and returns false.
  //  Parameters:
  //    None
  //  Return:
  //    boolean successful sale (true) or failure (false)
  public boolean makeSale()
  {
    if (deposit >= price && stock >= 1)
    {
    	change = deposit - price;
    	SnackBar.sales+=(double)(price)/100;
    	deposit = 0;
    	stock-=1;
    	
    	return true;
    }
    else
    {
    	change = deposit;
    	deposit = 0;
    	return false;
    }
  }

  //  Returns and zeroes out the amount of change (from the last
  //  sale or refund).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current change
  public int getChange()
  {
    return change;
  }
  
  public static double getTotalSales()
  {
	  return SnackBar.sales;
  }
 
}
