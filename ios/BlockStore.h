
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNBlockStoreSpec.h"

@interface BlockStore : NSObject <NativeBlockStoreSpec>
#else
#import <React/RCTBridgeModule.h>

@interface BlockStore : NSObject <RCTBridgeModule>
#endif

@end
