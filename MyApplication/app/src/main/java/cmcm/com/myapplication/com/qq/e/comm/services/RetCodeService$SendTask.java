package cmcm.com.myapplication.com.qq.e.comm.services;

class RetCodeService$SendTask
  implements Runnable
{
  private RetCodeService.RetCodeInfo a;
  private int b;

  RetCodeService$SendTask(RetCodeService paramRetCodeService, RetCodeService.RetCodeInfo paramRetCodeInfo, int paramInt)
  {
    this.a = paramRetCodeInfo;
    this.b = 100;
  }

  public void run()
  {
    RetCodeService.a(this.c, this.a, this.b);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.services.RetCodeService.SendTask
 * JD-Core Version:    0.6.2
 */