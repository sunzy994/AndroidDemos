package cmcm.com.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class n extends r<m>
{
  public n(m paramm)
  {
    super(paramm);
  }

  public View a(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.a.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public boolean a()
  {
    Window localWindow = this.a.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }

  public boolean a(k paramk)
  {
    return !this.a.isFinishing();
  }

  public LayoutInflater b()
  {
    return this.a.getLayoutInflater().cloneInContext(this.a);
  }

  public void b(k paramk)
  {
    this.a.a(paramk);
  }

  public void c()
  {
    this.a.d();
  }

  public boolean d()
  {
    return this.a.getWindow() != null;
  }

  public int e()
  {
    Window localWindow = this.a.getWindow();
    if (localWindow == null)
      return 0;
    return localWindow.getAttributes().windowAnimations;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     n
 * JD-Core Version:    0.6.2
 */