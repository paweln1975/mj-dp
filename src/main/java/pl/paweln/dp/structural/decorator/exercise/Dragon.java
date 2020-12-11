package pl.paweln.dp.structural.decorator.exercise;

public class Dragon
{
    private int age;
    private Lizard lizard;
    private Bird bird;

    public Dragon() {
        this.lizard = new Lizard();
        this.bird = new Bird();

    }

    public void setAge(int age)
    {
        this.lizard.age = age;
        this.bird.age = age;
        this.age = age;
    }
    public String fly()
    {
        return this.bird.fly();
    }
    public String crawl()
    {
        return this.lizard.crawl();
    }
}