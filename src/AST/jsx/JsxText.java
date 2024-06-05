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
        htmlBuilder.append(text);
        return htmlBuilder.toString();
    }

    public String convertToCss() {
        StringBuilder cssBuilder = new StringBuilder();
        return cssBuilder.toString();
    }

    public String convertToJs() {
        StringBuilder jsBuilder = new StringBuilder();
        return jsBuilder.toString();
    }
}
