package cmcm.com.myapplication;

import android.os.Bundle;

public final class bs
{
  private final String a;
  private CharSequence b;
  private CharSequence[] c;
  private boolean d = true;
  private Bundle e = new Bundle();

  public bs(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Result key can't be null");
    this.a = paramString;
  }

  public br a()
  {
    return new br(this.a, this.b, this.c, this.d, this.e);
  }

  public bs a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    return this;
  }

  public bs a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public bs a(CharSequence[] paramArrayOfCharSequence)
  {
    this.c = paramArrayOfCharSequence;
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     bs
 * JD-Core Version:    0.6.2
 */