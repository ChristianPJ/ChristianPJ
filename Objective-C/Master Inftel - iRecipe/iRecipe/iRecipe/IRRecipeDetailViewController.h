//
//  RecipeDetailViewController.h
//  iRecipe
//
//  Created by INFTEL 18 on 14/1/15.
//  Copyright (c) 2015 INFTEL 16. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "IRPerson.h"
#import "IRDataLoader.h"
#import "IRIngredientsTableViewController.H"

@interface IRRecipeDetailViewController : UIViewController

@property IRPerson *user;
@property (nonatomic, strong) NSNumber *recipeId;

@property (nonatomic, strong) IBOutlet UILabel *recipeLabel;

@property (strong, nonatomic) IBOutlet UILabel *recipeLabelTime;

@property (strong, nonatomic) IBOutlet UITextView *recipeTextView;

@property (strong, nonatomic) IBOutlet UILabel *recipeLabelUser;

@property (strong, nonatomic) IBOutlet UILabel *recipeLabelDate;

@property (strong, nonatomic) IBOutlet UIImageView *recipeImageView;
@end
