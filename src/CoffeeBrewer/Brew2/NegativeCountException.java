package CoffeeBrewer.Brew2;

/**
 * Created by HanWei on 19/10/2016.
 */
public class NegativeCountException extends Exception{
    private int count=0;
    public NegativeCountException() {
        super();
    }

    public NegativeCountException(String message) {
        super(message);
    }

    public void addPerson(){
        count++;
    }

    public void removePerson() throws NegativeCountException{
        if (count == 0){
            throw new NegativeCountException("Cannot remove a person");
        }else{
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}
