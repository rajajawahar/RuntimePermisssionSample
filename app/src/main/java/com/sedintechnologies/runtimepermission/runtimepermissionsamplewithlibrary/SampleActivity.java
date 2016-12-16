package com.sedintechnologies.runtimepermission.runtimepermissionsamplewithlibrary;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.rajeefmk.runtimepermissionhandler.PermissionUtils;
import com.rajeefmk.runtimepermissionhandler.PermissionsApi;

public class SampleActivity extends AppCompatActivity implements PermissionsApi.PermissionCallback {

  private static final String TAG = SampleActivity.class.getCanonicalName();
  private static final int SOME_LIST_OF_PERMISSION = 103;
  private String mPermission[] = new String[] {
      Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CAMERA,
      Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    PermissionsApi.getInstance().setPermissionCallback(this);
    if (PermissionUtils.hasPermission(this, mPermission,
        "App need the above permissions to proceed further", SOME_LIST_OF_PERMISSION)) {
    }
  }

  @Override public void onPermissionGranted(int i) {

  }

  @Override public void onPermissionDenied(int i) {

  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (this.isFinishing()) return;
    switch (requestCode) {
      case SOME_LIST_OF_PERMISSION:
        PermissionUtils.onRequestPermissionsResult(this, requestCode, permissions, grantResults,
            "Permission granted status");
        break;
    }
  }
}
