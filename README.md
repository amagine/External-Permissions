# External-Permissions
1) Add BaseActivity as a parent Activity of your activity
2) Implements BaseActivity.IPermissionRequest where you want to receive the output or result
3) Add following lines in OnCreate(Bundle bundle) or on click you want to show permission dialog

  // Here i have added 3 permission for demo, yours may different.

  // In case of activity.

    askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000, this);


  // In case of Fragment.

    mINavigationListener.askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000, this);

4) If user will allow all the permissions then you will receive onPermissionGranted callback with allowed true else false.

NOTE: If user clicked on never ask again then you will directly receive onPermissionGranted callback with allowed false.
