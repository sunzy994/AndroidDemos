package cmcm.com.myapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

public class ou
{
  private static final String a = "GameSDK." + ou.class.getSimpleName();

  public static void a(File paramFile)
  {
    a(paramFile, null);
  }

  public static void a(File paramFile, FilenameFilter paramFilenameFilter)
  {
    if (!paramFile.exists())
      throw new IllegalArgumentException(paramFile + " does not exist");
    if (!paramFile.isDirectory())
      throw new IllegalArgumentException(paramFile + " is not a directory");
    if (paramFilenameFilter == null);
    for (paramFilenameFilter = paramFile.listFiles(); paramFilenameFilter == null; paramFilenameFilter = paramFile.listFiles(paramFilenameFilter))
      throw new IOException("Failed to list contents of " + paramFile);
    int j = paramFilenameFilter.length;
    paramFile = null;
    int i = 0;
    while (true)
    {
      File localFile;
      if (i < j)
        localFile = paramFilenameFilter[i];
      try
      {
        b(localFile);
        label139: i += 1;
        continue;
        if (paramFile != null)
          throw paramFile;
      }
      catch (IOException paramFile)
      {
        break label139;
      }
    }
  }

  public static void b(File paramFile)
  {
    if (paramFile.isDirectory())
      c(paramFile);
    do
    {
      return;
      if (!paramFile.exists())
        throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete file: " + paramFile);
  }

  public static void c(File paramFile)
  {
    if (!paramFile.exists());
    do
    {
      return;
      a(paramFile);
    }
    while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ou
 * JD-Core Version:    0.6.2
 */