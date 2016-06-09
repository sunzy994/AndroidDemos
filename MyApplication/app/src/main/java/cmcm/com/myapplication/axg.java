package cmcm.com.myapplication;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import com.lazyswipe.widget.listview.DragSortListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class axg
{
  StringBuilder a = new StringBuilder();
  File b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  private int d = 0;
  private int e = 0;
  private boolean f = false;

  public axg(DragSortListView paramDragSortListView)
  {
    if (!this.b.exists());
    try
    {
      this.b.createNewFile();
      Log.d("mobeta", "file created");
      return;
    }
    catch (IOException paramDragSortListView)
    {
      Log.w("mobeta", "Could not create dslv_state.txt");
      Log.d("mobeta", paramDragSortListView.getMessage());
    }
  }

  public void a()
  {
    this.a.append("<DSLVStates>\n");
    this.e = 0;
    this.f = true;
  }

  public void b()
  {
    if (!this.f);
    do
    {
      return;
      this.a.append("<DSLVState>\n");
      int j = this.c.getChildCount();
      int k = this.c.getFirstVisiblePosition();
      this.a.append("    <Positions>");
      int i = 0;
      while (i < j)
      {
        this.a.append(k + i).append(",");
        i += 1;
      }
      this.a.append("</Positions>\n");
      this.a.append("    <Tops>");
      i = 0;
      while (i < j)
      {
        this.a.append(this.c.getChildAt(i).getTop()).append(",");
        i += 1;
      }
      this.a.append("</Tops>\n");
      this.a.append("    <Bottoms>");
      i = 0;
      while (i < j)
      {
        this.a.append(this.c.getChildAt(i).getBottom()).append(",");
        i += 1;
      }
      this.a.append("</Bottoms>\n");
      this.a.append("    <FirstExpPos>").append(DragSortListView.o(this.c)).append("</FirstExpPos>\n");
      this.a.append("    <FirstExpBlankHeight>").append(DragSortListView.c(this.c, DragSortListView.o(this.c)) - DragSortListView.d(this.c, DragSortListView.o(this.c))).append("</FirstExpBlankHeight>\n");
      this.a.append("    <SecondExpPos>").append(DragSortListView.p(this.c)).append("</SecondExpPos>\n");
      this.a.append("    <SecondExpBlankHeight>").append(DragSortListView.c(this.c, DragSortListView.p(this.c)) - DragSortListView.d(this.c, DragSortListView.p(this.c))).append("</SecondExpBlankHeight>\n");
      this.a.append("    <SrcPos>").append(DragSortListView.k(this.c)).append("</SrcPos>\n");
      this.a.append("    <SrcHeight>").append(DragSortListView.m(this.c) + this.c.getDividerHeight()).append("</SrcHeight>\n");
      this.a.append("    <ViewHeight>").append(this.c.getHeight()).append("</ViewHeight>\n");
      this.a.append("    <LastY>").append(DragSortListView.A(this.c)).append("</LastY>\n");
      this.a.append("    <FloatY>").append(DragSortListView.u(this.c)).append("</FloatY>\n");
      this.a.append("    <ShuffleEdges>");
      i = 0;
      while (i < j)
      {
        this.a.append(DragSortListView.a(this.c, k + i, this.c.getChildAt(i).getTop())).append(",");
        i += 1;
      }
      this.a.append("</ShuffleEdges>\n");
      this.a.append("</DSLVState>\n");
      this.d += 1;
    }
    while (this.d <= 1000);
    c();
    this.d = 0;
  }

  public void c()
  {
    boolean bool = false;
    if (!this.f)
      return;
    while (true)
    {
      try
      {
        if (this.e == 0)
        {
          FileWriter localFileWriter = new FileWriter(this.b, bool);
          localFileWriter.write(this.a.toString());
          this.a.delete(0, this.a.length());
          localFileWriter.flush();
          localFileWriter.close();
          this.e += 1;
          return;
        }
      }
      catch (IOException localIOException)
      {
        return;
      }
      bool = true;
    }
  }

  public void d()
  {
    if (this.f)
    {
      this.a.append("</DSLVStates>\n");
      c();
      this.f = false;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     axg
 * JD-Core Version:    0.6.2
 */