//
//  IRDataLoader.h
//  iRecipe
//
//  Created by INFTEL 22 on 15/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "IRRecipe.h"
#import "IRPerson.h"
#import "IRIngredient.h"

@interface IRDataLoader : NSObject

+(void)loadRecipes:(NSMutableDictionary *)recipes withCallback:(void (^)(void))callbackBlock;
+(void)loadRecipeWithId:(NSNumber *)idRecipe intoRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock;
+(void)loadIngredients:(NSMutableArray *)ingredients withRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock;
+(void)loadIngredientChecked:(NSMutableArray *)ingredients withUser:(IRPerson *)person withRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock;
+(void)loadPersonWithName:(NSString *)name withCallback:(void (^)(NSURLResponse *, NSData *, NSError *))callback;
+(void)insertRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock;
+(void)insertIngredient:(IRIngredient *)ingredient withCallback:(void (^)(NSURLResponse *, NSData *, NSError *))callback;
+(void)insertIngredientChecked:(IRIngredient *)ingredient withUser:(IRPerson *)user;
    
@end
