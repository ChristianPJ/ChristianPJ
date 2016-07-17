//
//  IRDataLoader.m
//  InOffApp
//
//  Created by Christian on 09/07/16.
//  Copyright (c) 2016 ChristianPJ. All rights reserved.
//

#import "IRDataLoader.h"

@implementation IRDataLoader

static NSString *const RestServiceLocation = @"http://vps185775.ovh.net:8080/InOffRestful-war/webresources/es.inoff.";
static NSString *const RestServiceWorks = @"works/";

+(void)loadWorks:(NSMutableDictionary *)works withCallback:(void (^)(void))callbackBlock {
    @autoreleasepool {
        
        NSURL *url = [[NSURL alloc] initWithString:[NSString stringWithFormat: @"%@%@", RestServiceLocation, RestServiceWorks]];
        NSURLRequest *request = [[NSURLRequest alloc] initWithURL:url];
        
        void (^callback)(NSURLResponse *, NSData *, NSError *) =
        ^(NSURLResponse *response, NSData *data, NSError *error) {
            if(data.length > 0 && error == nil){
                dispatch_queue_t mainQueue = dispatch_get_main_queue();
                
                NSError *errorJSON;
                NSArray *json = [NSJSONSerialization JSONObjectWithData:data options:NSJSONReadingMutableContainers error:&errorJSON];
                
                IRWorks *work;
                for (NSDictionary *object in json) {
                    @autoreleasepool {
                        work = [[IRWorks alloc] init];
                        work.idWork = [object valueForKey:@"idWork"];
                        work.iconWork = [object valueForKey:@"iconWork"];
                        work.nameWork = [object valueForKey:@"nameWork"];
                        work.dateWork = [object valueForKey:@"dateWork"];
                        work.activeWork = [object valueForKey:@"activeWork"];
                        work.idUserFK = [object valueForKey:@"idUserFK"];
                        
                        dispatch_async(mainQueue, ^{
                            NSString *firstLetter = [[work.nameWork substringToIndex:1] uppercaseString];
                            NSMutableArray *worksWithLetter = [works objectForKey:firstLetter];
                            if(worksWithLetter == nil){
                                [works setObject:[[NSMutableArray alloc] init] forKey:firstLetter];
                                 worksWithLetter = [works objectForKey:firstLetter];
                            }
                            [worksWithLetter addObject:work];
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

@end
