package com.blockstore

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.Promise

abstract class BlockStoreSpec internal constructor(context: ReactApplicationContext) :
  ReactContextBaseJavaModule(context) {

  abstract fun save(key: String, value: String, shouldBackupToCloud: boolean, promise: Promise);

  abstract fun retrieve(key: String, promise: Promise);

  abstract fun remove(key: String, promise: Promise);
}
