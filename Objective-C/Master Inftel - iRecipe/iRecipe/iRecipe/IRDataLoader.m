//
//  IRDataLoader.m
//  iRecipe
//
//  Created by INFTEL 22 on 15/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import "IRDataLoader.h"

@implementation IRDataLoader

static NSString *const RestServiceLocation = @"http://localhost:8080/inftelreciperest/webresources/es.inftel.data.";
static NSString *const RestServiceRecipe = @"recipe/";
static NSString *const RestServicePerson = @"person/";
static NSString *const RestServiceIngredient = @"ingredient/";
static NSString *const RestServicePersonHasIngredient = @"personhasingredient/";

+(void)loadRecipes:(NSMutableDictionary *)recipes withCallback:(void (^)(void))callbackBlock {
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@", RestServiceLocation, RestServiceRecipe]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
    
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
            
                NSError *errorJSON;
                NSArray *json = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
            
                IRRecipe *recipe;
                for (NSDictionary *object in json) {
                    @autoreleasepool {
                        recipe = [[IRRecipe alloc] init];
                        recipe.idRecipe = [object valueForKey:@"id"];
                        recipe.name = [object valueForKey:@"name"];
                        recipe.elaborationTime = [object valueForKey:@"elaborationTime"];
                        
                        dispatch_async(mainQueue, ^{
                            NSString *firstLetter = [[recipe.name substringToIndex:1] uppercaseString];
                            NSMutableArray *recipesWithLetter = [recipes objectForKey:firstLetter];
                            if(recipesWithLetter == nil){
                                [recipes setObject:[[NSMutableArray alloc] init] forKey:firstLetter];
                                recipesWithLetter = [recipes objectForKey:firstLetter];
                            }
                            [recipesWithLetter addObject:recipe];
                        });
                    }
                }
                dispatch_async(mainQueue, callbackBlock);
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:request queue:queue completionHandler:callback];
    }
}

+(void)loadRecipeWithId:(NSNumber *)idRecipe intoRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock{
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@%@", RestServiceLocation, RestServiceRecipe, idRecipe]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
        
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
                
                NSError *errorJSON;
                NSDictionary *object = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
                
                recipe.idRecipe = [object valueForKey:@"id"];
                recipe.name = [object valueForKey:@"name"];
                recipe.elaborationTime = [object valueForKey:@"elaborationTime"];
                recipe.elaboration = [object valueForKey:@"description"];
                
                NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
                [dateFormat setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"];
                NSDate *date = [dateFormat dateFromString:[object valueForKey:@"creationDate"]];
                recipe.creationDate = date;
                
                NSMutableDictionary *recipePerson = [object valueForKey:@"person"];
                IRPerson *person = [[IRPerson alloc] init];
                person.idPerson = [recipePerson valueForKey:@"id"];
                person.name = [recipePerson valueForKey:@"name"];
                recipe.person = person;
                recipe.choosenFoto = [object valueForKey:@"photo"];
                
                dispatch_async(mainQueue, callbackBlock);
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:request queue:queue completionHandler:callback];
    }
}

+(void)loadIngredients:(NSMutableArray *)ingredients withRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock {
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@recipe=%@", RestServiceLocation, RestServiceIngredient, recipe.idRecipe]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
        
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
                
                NSError *errorJSON;
                NSArray *json = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
                
                IRIngredient *ingredient;
                for (NSDictionary *object in json) {
                    @autoreleasepool {
                        ingredient = [[IRIngredient alloc] init];
                        ingredient.idIngredient = [object valueForKey:@"id"];
                        ingredient.name = [object valueForKey:@"name"];
                        ingredient.quantity = [object valueForKey:@"quantity"];
                        ingredient.recipe = recipe;
                        ingredient.completed = NO;
                        
                        dispatch_async(mainQueue, ^{
                            [ingredients addObject:ingredient];
                        });
                    }
                }
                
                dispatch_async(mainQueue, callbackBlock);
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:request queue:queue completionHandler:callback];
    }
}

+(void)loadIngredientChecked:(NSMutableArray *)ingredients withUser:(IRPerson *)person withRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock {
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@recipe=%@&&person=%@", RestServiceLocation, RestServicePersonHasIngredient, recipe.idRecipe, person.idPerson]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
                
                NSError *errorJSON;
                NSArray *json = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
                for (NSDictionary *object in json) {
                    @autoreleasepool {
                        NSMutableDictionary *ingredientData = [object valueForKey:@"ingredient"];
                        IRIngredient *ingredient;
                        ingredient = [[IRIngredient alloc] init];
                        ingredient.idIngredient = [ingredientData valueForKey:@"id"];
                        dispatch_async(mainQueue, ^{
                            for (IRIngredient *ing in ingredients) {
                                if([ingredient.idIngredient compare:ing.idIngredient] == NSOrderedSame){
                                    ing.completed = [[object valueForKey:@"completed"] integerValue];
                                    break;
                                }
                            }
                        });
                    }
                }
                
                dispatch_async(mainQueue, callbackBlock);
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:request queue:queue completionHandler:callback];
    }
}


+(void)loadPersonWithName:(NSString *)name withCallback:(void (^)(NSURLResponse *, NSData *, NSError *))callback{
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@name=%@", RestServiceLocation, RestServicePerson, name]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
    
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:request queue:queue completionHandler:callback];
    }
}

+(void)insertRecipe:(IRRecipe *)recipe withCallback:(void (^)(void))callbackBlock{
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@", RestServiceLocation, RestServiceRecipe]];
        NSMutableURLRequest *urlRequest = [[NSMutableURLRequest alloc] initWithURL:url];
        
        
        urlRequest.HTTPMethod = @"POST";
        [urlRequest setValue:@"application/json; charset=utf-8" forHTTPHeaderField:@"Content-Type"];
        NSError *error = nil;
        
        NSMutableDictionary *person = [[NSMutableDictionary alloc] init];
        [person setObject:recipe.person.name forKey:@"name"];
        [person setObject:recipe.person.idPerson forKey:@"id"];
        
        NSMutableDictionary *json = [[NSMutableDictionary alloc] init];
        [json setObject:recipe.elaboration forKey:@"description"];
        [json setObject:recipe.elaborationTime forKey:@"elaborationTime"];
        [json setObject:recipe.name forKey:@"name"];
        if(recipe.choosenFoto != nil){
            [json setObject:recipe.choosenFoto forKey:@"photo"];
        }
        [json setObject:person forKey:@"person"];
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"];
        NSString *stringDate = [dateFormatter stringFromDate:recipe.creationDate];
        [json setObject:stringDate forKey:@"creationDate"];
        
        NSData *requestBodyData = [NSJSONSerialization dataWithJSONObject:json options:0 error:&error];
        
        urlRequest.HTTPBody = requestBodyData;
        
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
                NSError *errorJSON;
                NSDictionary *object = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
                recipe.idRecipe = [object valueForKey:@"id"];
                dispatch_async(mainQueue, callbackBlock);
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:urlRequest queue:queue completionHandler:callback];

    }
   }

+(void)insertIngredient:(IRIngredient *)ingredient withCallback:(void (^)(NSURLResponse *, NSData *, NSError *))callback{
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@", RestServiceLocation, RestServiceIngredient]];
        NSMutableURLRequest *urlRequest = [[NSMutableURLRequest alloc] initWithURL:url];
        
        
        urlRequest.HTTPMethod = @"POST";
        [urlRequest setValue:@"application/json; charset=utf-8" forHTTPHeaderField:@"Content-Type"];
        NSError *error = nil;
        
        IRRecipe *recipe = ingredient.recipe;
        NSMutableDictionary *person = [[NSMutableDictionary alloc] init];
        [person setObject:recipe.person.name forKey:@"name"];
        [person setObject:recipe.person.idPerson forKey:@"id"];
        
        NSMutableDictionary *json = [[NSMutableDictionary alloc] init];
        [json setObject:recipe.idRecipe forKey:@"id"];
        [json setObject:recipe.elaboration forKey:@"description"];
        [json setObject:recipe.elaborationTime forKey:@"elaborationTime"];
        [json setObject:recipe.name forKey:@"name"];
        [json setObject:person forKey:@"person"];
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"];
        NSString *stringDate = [dateFormatter stringFromDate:recipe.creationDate];
        [json setObject:stringDate forKey:@"creationDate"];
        
        NSMutableDictionary *filaIngrediente = [[NSMutableDictionary alloc] init];
        [filaIngrediente setObject:ingredient.quantity forKey:@"quantity"];
        [filaIngrediente setObject:ingredient.name forKey:@"name"];
        [filaIngrediente setObject:json forKey:@"recipe"];
        
        NSData *requestBodyData = [NSJSONSerialization dataWithJSONObject:filaIngrediente options:0 error:&error];
        
        urlRequest.HTTPBody = requestBodyData;
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:urlRequest queue:queue completionHandler:callback];
    }
    
}

+(void)insertIngredientChecked:(IRIngredient *)ingredient withUser:(IRPerson *)user {
    @autoreleasepool {
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@", RestServiceLocation, RestServicePersonHasIngredient]];
        NSMutableURLRequest *urlRequest = [[NSMutableURLRequest alloc] initWithURL:url];
        
        
        urlRequest.HTTPMethod = @"POST";
        [urlRequest setValue:@"application/json; charset=utf-8" forHTTPHeaderField:@"Content-Type"];
        NSError *error = nil;
        
        IRRecipe *recipe = ingredient.recipe;
        NSMutableDictionary *personJson = [[NSMutableDictionary alloc] init];
        [personJson setObject:recipe.person.name forKey:@"name"];
        [personJson setObject:recipe.person.idPerson forKey:@"id"];
        
        NSMutableDictionary *recipeJson = [[NSMutableDictionary alloc] init];
        [recipeJson setObject:recipe.idRecipe forKey:@"id"];
        [recipeJson setObject:recipe.elaboration forKey:@"description"];
        [recipeJson setObject:recipe.elaborationTime forKey:@"elaborationTime"];
        [recipeJson setObject:recipe.name forKey:@"name"];
        [recipeJson setObject:personJson forKey:@"person"];
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"];
        NSString *stringDate = [dateFormatter stringFromDate:recipe.creationDate];
        [recipeJson setObject:stringDate forKey:@"creationDate"];
        
        NSMutableDictionary *ingredienteJson = [[NSMutableDictionary alloc] init];
        [ingredienteJson setObject:ingredient.idIngredient forKey:@"id"];
        [ingredienteJson setObject:ingredient.quantity forKey:@"quantity"];
        [ingredienteJson setObject:ingredient.name forKey:@"name"];
        [ingredienteJson setObject:recipeJson forKey:@"recipe"];
        
        NSMutableDictionary *userJson = [[NSMutableDictionary alloc] init];
        [userJson setObject:user.name forKey:@"name"];
        [userJson setObject:user.idPerson forKey:@"id"];
        
        NSMutableDictionary *ingredientCheckedJson = [[NSMutableDictionary alloc] init];
        [ingredientCheckedJson setObject:ingredient.completed ? @"true" : @"false" forKey:@"completed"];
        [ingredientCheckedJson setObject:userJson forKey:@"person"];
        [ingredientCheckedJson setObject:ingredienteJson forKey:@"ingredient"];
        
        NSData *requestBodyData = [NSJSONSerialization dataWithJSONObject:ingredientCheckedJson options:0 error:&error];
        
        urlRequest.HTTPBody = requestBodyData;
        
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                
            }
        };
        
        NSOperationQueue *queue = [[NSOperationQueue alloc]init];
        [NSURLConnection sendAsynchronousRequest:urlRequest queue:queue completionHandler:callback];

    }
  }

@end
