//
//  IRDataLoader.h
//  InOffApp
//
//  Created by Christian on 09/07/16.
//  Copyright (c) 2016 ChristianPJ. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "IRWorks.h"

@interface IRDataLoader : NSObject

+(void)loadWorks:(NSMutableDictionary *)works withCallback:(void (^)(void))callbackBlock;

@end

