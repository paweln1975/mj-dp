package pl.paweln.dp.behavioral.state;

public class OnState extends State {
    public OnState() {
        logger.info("Light turned on");
    }

    @Override
    void off(LightSwitch ls) {
        logger.info("Switching light off");
        ls.setState(new OffState());
    }
}
