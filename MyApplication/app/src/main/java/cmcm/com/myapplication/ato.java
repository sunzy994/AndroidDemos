package cmcm.com.myapplication;

import java.io.File;

public class ato
{
  public final File a;
  public final File b;
  public final String c;
  public final boolean d;

  public ato(File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
  {
    this.a = paramFile1;
    this.b = paramFile2;
    this.c = paramString;
    this.d = paramBoolean;
  }

  public ato(File paramFile, String paramString, boolean paramBoolean)
  {
    this(paramFile, new File(paramFile.getAbsolutePath() + "-temp"), paramString, paramBoolean);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ato
 * JD-Core Version:    0.6.2
 */