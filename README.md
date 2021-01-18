Simple project showcasing an issue happening on Android 10 & Android 11 (at least) where a
`SecurityException: Permission Denial: reading androidx.core.content.FileProvider uri .. uid=1000 requires the provider be exported, or grantUriPermission()`
is posted in logcat although everything seems to be working as expected from a user standpoint.

> E/DatabaseUtils: Writing exception to parcel
      java.lang.SecurityException: Permission Denial: reading androidx.core.content.FileProvider uri content://com.example.fileprovidersharefilebug/myimages/test.png from pid=3186, uid=1000 requires the provider be exported, or grantUriPermission()
          at android.content.ContentProvider.enforceReadPermissionInner(ContentProvider.java:820)
          at android.content.ContentProvider$Transport.enforceReadPermission(ContentProvider.java:684)
          at android.content.ContentProvider$Transport.enforceFilePermission(ContentProvider.java:674)
          at android.content.ContentProvider$Transport.openTypedAssetFile(ContentProvider.java:548)
          at android.content.ContentProviderNative.onTransact(ContentProviderNative.java:327)
          at android.os.Binder.execTransactInternal(Binder.java:1154)
          at android.os.Binder.execTransact(Binder.java:1123)