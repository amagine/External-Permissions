package in.amagine.permissions;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import in.amagine.permissions.base.BaseActivity;
import in.amagine.permissions.base.BaseFragment;

public class MainFragment extends BaseFragment implements BaseActivity.IPermissionRequest
{
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mINavigationListener.askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000, this);
    }

    @Override
    public void onPermissionGranted(boolean allowed, int requestCode)
    {
        Toast.makeText(getActivity(), "Permission Granted: "+allowed, Toast.LENGTH_SHORT).show();
    }
}
