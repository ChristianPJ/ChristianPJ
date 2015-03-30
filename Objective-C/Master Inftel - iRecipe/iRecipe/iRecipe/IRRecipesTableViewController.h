//
//  ToDoListTableViewController.h
//  ToDolist
//
//  Created by INFTEL 20 on 12/1/15.
//  Copyright (c) 2015 INFTEL 21. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "IRRecipeDetailViewController.h"
#import "IRPerson.h"

@interface IRRecipesTableViewController : UITableViewController

@property IRPerson *user;

- (IBAction)unwindToList:(UIStoryboardSegue *)segue;

@end

