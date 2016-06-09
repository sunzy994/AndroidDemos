package cmcm.com.myapplication;

import java.util.Scanner;

public class jy
{
  private String a;
  private String b;
  private String c;
  private String d;

  public jy(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.a = paramString3;
  }

  public jy(char[] paramArrayOfChar)
  {
    paramArrayOfChar = new Scanner(new String(paramArrayOfChar));
    while (paramArrayOfChar.hasNextLine())
    {
      String str = paramArrayOfChar.nextLine();
      if (str.startsWith("url="))
        this.c = str.substring("url=".length()).trim();
      else if (str.startsWith("version="))
        this.a = str.substring("version=".length()).trim();
      else if (str.startsWith("data="))
        this.b = str.substring("data=".length()).trim();
    }
    paramArrayOfChar.close();
  }

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     jy
 * JD-Core Version:    0.6.2
 */