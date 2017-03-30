package in.amagine.permissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by administrator on 3/27/17.
 */

public class BaseActivity extends AppCompatActivity
{
    private int                                 mRequestCode;
    private WeakReference<IPermissionRequest>   mIPermissionRequest;

    public void askForPermission(String[] permissions, int requestCode)
    {
        mRequestCode = requestCode;
        List<String> permissionList = new LinkedList<>(Arrays.asList(permissions));
        for (Iterator<String> iterator = permissionList.iterator(); iterator.hasNext(); )
        {
            String permission = iterator.next();
            int check = ContextCompat.checkSelfPermission(this, permission);
            if (check == PackageManager.PERMISSION_GRANTED)
            {
                iterator.remove();
            }
        }

        if (permissionList.size() > 0)
        {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), requestCode);
        }
        else
        {
            notifyListener(true, requestCode);
        }
    }

    public void setListener(IPermissionRequest listener)
    {
        mIPermissionRequest = new WeakReference<>(listener);
    }

    private void notifyListener(boolean allowed, int requestCode)
    {
        try
        {
            mIPermissionRequest.get().onPermissionGranted(allowed, requestCode);
        }
        catch (Exception ignored)
        {

        }
    }

    public boolean contains(final int[] grantedList, final int granted)
    {
        boolean result = false;
        for(int i : grantedList)
        {
            if(i == granted)
            {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == mRequestCode)
        {
            if (contains(grantResults, PackageManager.PERMISSION_DENIED))
            {
                notifyListener(false, mRequestCode);
            } else
            {
                notifyListener(true, mRequestCode);
            }
        }
    }

    public interface IPermissionRequest
    {
        void onPermissionGranted(boolean allowed, int requestCode);
    }
}
