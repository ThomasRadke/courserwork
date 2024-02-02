import java.util.EventObject;

public class RevealEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RevealEvent(Object source) {
        super(source);
    }
}
