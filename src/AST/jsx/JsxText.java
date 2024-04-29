package AST.jsx;

public class JsxText {
    private String text;

    public JsxText()
    {

    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
