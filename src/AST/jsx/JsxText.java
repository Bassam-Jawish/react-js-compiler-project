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

    public String convertToHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        jsBuilder.append(text);
        return jsBuilder.toString();
    }
}
