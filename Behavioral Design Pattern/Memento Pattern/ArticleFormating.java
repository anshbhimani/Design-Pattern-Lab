import java.util.List;
import java.util.ArrayList;

class Momento_Object
{
    private int fontSize;
    private String content;
    private String fontType;

    public Momento_Object(int size,String con, String font)
    {
         fontSize = size;
         content = con;
         fontType = font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getContent() {
        return content;
    }

    public String getFontType() {
        return fontType;
    }
}

class OriginatorObject
{
    // real object whose state needed to be preserved
   private int fontSize;
   private String content;
   private String fontType;

   public OriginatorObject(int size,String con, String font)
   {
        fontSize = size;
        content = con;
        fontType = font;
   }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public String getFontType() {
        return fontType;
    }


    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public Momento_Object saveStatetoMomento()
    {
        return new Momento_Object(fontSize,content,fontType);
    }

    public void restoreState(Momento_Object m)
    {
        content = m.getContent();
        fontSize = m.getFontSize();
        fontType = m.getFontType();
    }

    public String toString()
    {
        return "Content :" + content + ", Font Size : " + fontSize + ", Font Type : " + fontType;
    }
}

class CareTakerObject
{
    List<Momento_Object> lm = new ArrayList<Momento_Object>();

    public void addMomentoObject(Momento_Object m)
    {
        lm.add(m);
    }

    public Momento_Object getMomentoObject(int i)
    {
        return lm.get(i);
    }
}

public class ArticleFormating
{
    public static void main(String[] args) 
    {
        OriginatorObject o1 = new OriginatorObject(15, "Hello World", "Times New Roman");
        System.out.println(o1);
        
        CareTakerObject c1 = new CareTakerObject();
        Momento_Object m = o1.saveStatetoMomento();

        System.out.println(" ");
        System.out.println("After making changes");
        c1.addMomentoObject(m);

        o1.setContent("assd");
        o1.setFontType("Times New Roman");
        o1.setFontSize(77);

        System.out.println(o1);

        System.out.println(" ");
        o1.restoreState(m);
        System.out.println("After Restoring State : ");
        System.out.println(o1);
    }
}