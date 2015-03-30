//
//  IRIngredient.h
//  iRecipe
//
//  Created by INFTEL 22 on 15/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "IRRecipe.h"

@interface IRIngredient : NSObject

@property NSNumber *idIngredient;
@property NSString *name;
@property NSString *quantity;
@property IRRecipe *recipe;
@property BOOL completed;

@end
