package pl.paweln.dp.creational.builder;

public class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.setName(rootName);
    }

    public void addChild(String childName, String childText) {
        HtmlElement htmlElement = new HtmlElement(childName, childText);
        root.addElement(htmlElement);
    }

    public void clear() {
        this.root = new HtmlElement();
        this.root.setName(rootName);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
