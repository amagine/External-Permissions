package in.amagine.permissions.interfaces;

import in.amagine.permissions.base.BaseActivity;

public interface INavigationListener
{
    void askForPermission(String[] permissions, int requestCode, BaseActivity.IPermissionRequest listener);
}
