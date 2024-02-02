public class Main {
    public static void main(String[] args) {

        Pizza p =new Pizza();
        System.out.println(p);
        System.out.println(p.getPrice());

        Pizza p2 = new PepperoniPizza();
        System.out.println(p2);
        System.out.println(p2.getPrice());

        PizzaDecorator pp = new PeppperoniDecorator(p);
        System.out.println(pp);
        System.out.println(pp.getPrice());

        PizzaDecorator ppp = new SausageDecorator(p);
        PizzaDecorator pppp = new PeppperoniDecorator(ppp);
        System.out.println(pppp);
        System.out.println(pppp.getPrice());
    }
}