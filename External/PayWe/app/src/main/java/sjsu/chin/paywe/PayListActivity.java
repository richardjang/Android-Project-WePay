package sjsu.chin.paywe;

import android.app.Fragment;

/**
 * Created by Cann on 11/29/2015.
 */
public class PayListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PayListFragment();
    }
}
