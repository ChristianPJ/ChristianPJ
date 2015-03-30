//
//  ToDoItem.h
//  ToDoList
//
//  Created by INFTEL 18 on 12/1/15.
//  Copyright (c) 2015 INFTEL 18. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ToDoItem : NSObject


@property NSString *itemName;
@property BOOL completed;
@property (readonly) NSDate *creationDate;

@end
