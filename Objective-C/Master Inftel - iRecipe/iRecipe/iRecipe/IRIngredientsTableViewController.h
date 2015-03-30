//
//  IngredientsTableViewController.h
//  iRecipe
//
//  Created by INFTEL 18 on 16/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "IRDataLoader.h"

@interface IRIngredientsTableViewController : UITableViewController

@property (nonatomic, strong) IRRecipe *recipeIdIngred;
@property IRPerson *user;

@end
