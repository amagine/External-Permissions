package in.amagine.permissions;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements BaseActivity.IPermissionRequest
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener(this);
        askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
    }

    @Override
    public void onPermissionGranted(boolean allowed, int requestCode)
    {
        Toast.makeText(this, "Permission Granted: "+allowed, Toast.LENGTH_SHORT).show();
    }
}
