package com.blockstore

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.google.android.gms.auth.blockstore.*

class BlockStoreModule internal constructor(context: ReactApplicationContext) :
  BlockStoreSpec(context) {

  private val blockStoreClient: BlockstoreClient by lazy {
    Blockstore.getClient(
      reactApplicationContext
    )
  }

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  override fun save(key: String, value: String, shouldBackupToCloud: Boolean, promise: Promise) {
    val bytes = value.toByteArray(Charsets.UTF_8)

    val storeRequest1 = StoreBytesData.Builder()
      .setBytes(bytes)
      .setKey(key)
      .setShouldBackupToCloud(shouldBackupToCloud)
      .build()

    blockStoreClient.storeBytes(storeRequest1)
      .addOnSuccessListener {
        promise.resolve(true)
      }
      .addOnFailureListener { e ->
        promise.resolve(false)
      }
  }

  @ReactMethod
  override fun retrieve(key: String, promise: Promise) {
    val retrieveRequest = RetrieveBytesRequest.Builder()
      .setKeys(listOf(key))
      .build()

    blockStoreClient.retrieveBytes(retrieveRequest)
      .addOnSuccessListener {
        promise.resolve(if (it.blockstoreDataMap.containsKey(key)) it.blockstoreDataMap[key] else null)
      }
      .addOnFailureListener {
        promise.resolve(null)
      }
  }

  @ReactMethod
  override fun remove(key: String, promise: Promise) {
    val deleteRequest = DeleteBytesRequest.Builder()
      .setKeys(listOf(key))
      .build()

    blockStoreClient.deleteBytes(deleteRequest)
      .addOnSuccessListener {
        promise.resolve(true)
      }
      .addOnFailureListener {
        promise.resolve(false)
      }
  }

  companion object {
    const val NAME = "BlockStore"
  }
}
