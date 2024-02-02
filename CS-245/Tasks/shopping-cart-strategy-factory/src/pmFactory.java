public class pmFactory {

    public PaymentMethod createPM(String choice){
        PaymentMethod pm;
        if (choice.equals("z")){
            pm = new zenMoMethod();
        }
        else if (choice.equals("p")){
            pm = new zenMoMethod();
        }
        else if(choice.equals("c")){
            pm = new creditCardMethod();
        }
        else{
            throw new IllegalArgumentException("Invalid Payment method");
        }
        return pm;
    }
}
