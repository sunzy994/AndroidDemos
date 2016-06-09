package cmcm.com.myapplication.com.lazyswipe.features.theme.preview;

import aje;
import ajh;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import aoq;
import aor;
import aou;
import arl;
import asq;
import asr;
import com.lazyswipe.ui.BaseFragment;
import com.lazyswipe.widget.FragmentTabIndicator;
import com.lazyswipe.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class ThemesActivity extends aoq
{
  protected List<aor<BaseFragment>> g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aor(getString(2131231092), ajh.class));
    localArrayList.add(new aor(getString(2131231091), aje.class));
    return localArrayList;
  }

  protected void h()
  {
    super.h();
    int i = aou.b();
    if (Build.VERSION.SDK_INT >= 21)
      asq.a(this, i);
    this.l.setBackgroundColor(i);
    this.l.setTitleColor(getResources().getColor(2131689547));
    asr.a(this.l, 2131755063).setBackgroundColor(i);
  }

  protected void i()
  {
    super.i();
    this.j.setBackgroundColor(aou.b());
  }

  protected int j()
  {
    if (arl.i(this))
      return super.j();
    return 1;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.features.theme.preview.ThemesActivity
 * JD-Core Version:    0.6.2
 */