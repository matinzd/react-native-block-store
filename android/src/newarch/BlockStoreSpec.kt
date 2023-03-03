package com.blockstore

import com.facebook.react.bridge.ReactApplicationContext

abstract class BlockStoreSpec internal constructor(context: ReactApplicationContext) :
  NativeBlockStoreSpec(context) {
}
