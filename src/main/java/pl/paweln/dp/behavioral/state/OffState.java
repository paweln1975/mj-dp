package pl.paweln.dp.behavioral.state;

public class OffState extends State {
    public OffState() {
        logger.info("Light turned off");
    }

    @Override
    void on(LightSwitch ls) {
        logger.info("Switching light on");
        ls.setState(new OnState());
    }
}
