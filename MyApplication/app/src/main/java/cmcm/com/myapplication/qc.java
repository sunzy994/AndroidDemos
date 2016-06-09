package cmcm.com.myapplication;

public abstract class qc
{
  public void a(int paramInt, String paramString)
  {
  }

  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    po.c("[onFailure]", "ResponseHandler.onFailure:\nstatusCode=" + paramInt + "\n" + "errorResponse=" + paramString + "\n" + "e=" + paramThrowable.getStackTrace());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qc
 * JD-Core Version:    0.6.2
 */