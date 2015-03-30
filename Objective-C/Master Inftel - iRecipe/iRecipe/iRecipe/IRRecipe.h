//
//  IRRecipe.h
//  iRecipe
//
//  Created by INFTEL 22 on 15/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "IRPerson.h"

@interface IRRecipe : NSObject

@property NSNumber *idRecipe;
@property NSString *name;
@property NSString *elaborationTime;
@property NSString *elaboration;
@property NSDate *creationDate;
@property IRPerson *person;
@property NSMutableArray *ingredients;
@property NSString *choosenFoto;
@end
